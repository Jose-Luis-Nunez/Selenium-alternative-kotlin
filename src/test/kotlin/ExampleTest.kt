import it.skrape.core.htmlDocument
import it.skrape.expect
import it.skrape.matchers.toBe
import it.skrape.matchers.toBePresent
import it.skrape.selects.eachHref
import it.skrape.selects.html5.a
import it.skrape.selects.html5.h1
import it.skrape.selects.html5.label
import it.skrape.selects.html5.li
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

    @Test
    fun `check idealo logo is visible `() {
        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    a {
                        withClass = "i-header-logo"
                        findFirst {
                            toBePresent
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `check title of top products carousel is visible`() {
        val topProductsCarouselSelector = "#popular-products-section .stage-title"
        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    topProductsCarouselSelector {
                        findFirst {
                            text toBe "Beliebteste Produkte"
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `check computerbild logo is visible`() {
        val computerBildLogoSelector = ".i-header-row .i-header-cobi"
        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    computerBildLogoSelector {
                        findFirst {
                            toBePresent
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `check 20 footer links exist`() {
        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    li {
                        withClass = "pageFooter-serviceBoxListItem"
                        findAll {
                            eachHref().size toBe 20
                        }
                    }
                }
            }
        }
    }
}

