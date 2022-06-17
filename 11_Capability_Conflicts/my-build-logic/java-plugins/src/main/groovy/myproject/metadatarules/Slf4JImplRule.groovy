package myproject.metadatarules

import org.gradle.api.artifacts.CacheableRule
import org.gradle.api.artifacts.ComponentMetadataContext
import org.gradle.api.artifacts.ComponentMetadataRule

@CacheableRule
abstract class Slf4JImplRule implements ComponentMetadataRule {

    @Override
    void execute(ComponentMetadataContext context) {
        def version = context.details.id.version
        context.details.allVariants {
            withCapabilities {
                addCapability("org.slf4j", "slf4j-impl", version)
            }
        }
    }
}