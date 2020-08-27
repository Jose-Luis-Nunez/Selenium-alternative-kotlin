import it.skrape.core.htmlDocument
import it.skrape.expect
import it.skrape.matchers.toBe
import it.skrape.matchers.toBePresent
import it.skrape.selects.html5.a
import it.skrape.selects.html5.h1
import it.skrape.selects.html5.label
import it.skrape.skrape
import org.junit.jupiter.api.Test

class ExampleTest {

    @Test
    fun `check header claim is visible`() {
        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    h1 {
                        withClass = "i-header-claim-primary"
                        findFirst {
                            text toBe "Deutschlands großer Preisvergleich"
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `check text in searchlabel is displayed `() {
        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    label {
                        withClass = "i-search-label"
                        findFirst {
                            text toBe "Ich suche ..."
                        }
                    }
                }
            }
        }
    }
}

