package webforms.server.routers;

import webforms.server.model.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RouterManager {
    @Autowired
    protected Set<RouterPlugin> registry;

    public Set<String> getRouterTypes() {
        return this.registry.stream().map(RouterPlugin::getRouterName).collect(Collectors.toSet());
    }

    public Optional<RouterPlugin> getRouter(Router formRouter) {
        return this.registry.stream().filter(f -> f.getRouterName().equals(formRouter.getRouterClass())).findFirst();
    }
}
