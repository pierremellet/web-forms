const YAML = require('yaml');
const fs = require('fs');
const mustache = require('mustache');

const file = fs.readFileSync('../openapi.yaml', 'utf8');
const template = fs.readFileSync('./tools/generators/api.mustache', 'utf8');
const openapi = YAML.parse(file);

const schemas = openapi.components.schemas
const interfaces: any[] = [];

function getType(prop: any) {
    const regex = /\/([^/]+)$/;
    if (schemas[schema].properties[prop].$ref) {
        return schemas[schema].properties[prop].$ref.match(regex)[1];
    }

    if (schemas[schema].properties[prop].type) {
        return schemas[schema].properties[prop].type;
    }

    if (schemas[schema].properties[prop].items.$ref) {
        return schemas[schema].properties[prop].items.$ref.match(regex)[1] + "[]";
    }

    if (schemas[schema].properties[prop].items.type) {
        return schemas[schema].properties[prop].items.type + "[]";
    }
}

for (var schema in schemas) {

    const properties: any[] = [];
    for (var prop in schemas[schema].properties) {

        var type = getType(prop);
        if (['string', 'number', 'boolean', 'object'].indexOf(type) < 0) {
            type = type;
        }
        properties.push({
            "name": prop,
            "type": type,
            "description": schemas[schema].properties[prop].description,
            "required": schemas[schema].required?.indexOf(prop) >= 0 ? '' : '?'
        })
    }

    interfaces.push({
        "name": schema,
        "properties": properties
    });

}



const dataset = {
    "interfaces": interfaces
}

const rendered = mustache.render(template, dataset);


fs.writeFileSync('src/api/api.d.ts', rendered);


