import myproject.metadatarules.Slf4JImplRule

dependencies.components {
    withModule<Slf4JImplRule>("org.slf4j:slf4j-simple")
    withModule<Slf4JImplRule>("ch.qos.logback:logback-classic")
}