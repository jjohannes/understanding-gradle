module org.example.modulea {
    requires jakarta.activation;
    requires transitive org.slf4j;
    requires static jakarta.el;
    requires static transitive jakarta.servlet;

    exports mypackage.modulea;
}
