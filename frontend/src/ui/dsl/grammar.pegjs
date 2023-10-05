Expression = left:Field _ "==" _ right:Reference {
    return { type: "comparison", left, right };
  }

  Field = string:[a-z]* {
      return  { type: "fieldId", value:string.join('') };
  }

  Reference = "&" val:[0-9a-zA-Z]+ {
    return { type: "fieldValue", value: (val.join('')) };
  }

  _ = [ \t\n\r]* // Whitespace