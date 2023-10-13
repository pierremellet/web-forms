package webforms.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Router
 */

public class Router {

    private String routerClass;

    private Object routerConfig;

    /**
     * Default constructor
     *
     * @deprecated Use {@link Router#Router(String, Object)}
     */
    @Deprecated
    public Router() {
        super();
    }

    /**
     * Constructor with only required parameters
     */
    public Router(String routerClass, Object routerConfig) {
        this.routerClass = routerClass;
        this.routerConfig = routerConfig;
    }

    public Router routerClass(String routerClass) {
        this.routerClass = routerClass;
        return this;
    }

    /**
     * Get routerClass
     *
     * @return routerClass
     */
    @NotNull
    @JsonProperty("routerClass")
    public String getRouterClass() {
        return routerClass;
    }

    public void setRouterClass(String routerClass) {
        this.routerClass = routerClass;
    }

    public Router routerConfig(Object routerConfig) {
        this.routerConfig = routerConfig;
        return this;
    }

    /**
     * Get routerConfig
     *
     * @return routerConfig
     */
    @NotNull
    @JsonProperty("routerConfig")
    public Object getRouterConfig() {
        return routerConfig;
    }

    public void setRouterConfig(Object routerConfig) {
        this.routerConfig = routerConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Router router = (Router) o;
        return Objects.equals(this.routerClass, router.routerClass) &&
                Objects.equals(this.routerConfig, router.routerConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routerClass, routerConfig);
    }

    @Override
    public String toString() {
        String sb = "class Router {\n" +
                "    routerClass: " + toIndentedString(routerClass) + "\n" +
                "    routerConfig: " + toIndentedString(routerConfig) + "\n" +
                "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

