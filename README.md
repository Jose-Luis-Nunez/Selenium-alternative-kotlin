# Example project using skrape{it}

This **[Kotlin](https://kotlinlang.org)** project is an example projekt using the [skrape{it}](http://www.skrape.it/) library from [Christian Dräger](https://github.com/christian-draeger) as an alternative to selenium  

## Quick Start
### Read the Docs
You'll always find the latest documentation, release notes and examples at **[https://docs.skrape.it](https://docs.skrape.it)**.
If you don't want to read that much or just want to get a rough overview on how to use **skrape{it}**, you can have a look at the [Documentation by Example](#documentation-by-example) section:

## Write tests

```kotlin
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

    @Test
    fun `check content of bargain badge contains percentage and is numeric`() {
        val salesBadgedPercentageSelector = ".bargains-list .sales-badge-sign"
        val salesBadgedAmountSelector = ".bargains-list .sales-badge"

        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    salesBadgedPercentageSelector {
                        findAll {
                            eachText() toContain "%"
                        }
                    }
                    salesBadgedAmountSelector {
                        findAll {
                            isNumeric
                        }
                    }
                }
            }
        }
    }

    @Test
    fun `check content of bargain badge contains percentage and is numeric with nested selector`() {

        skrape {
            url = "https://www.idealo.de/"
            expect {
                htmlDocument {
                    div {
                        withClass = "bargains-list"
                        findAll {
                            div {
                                withClass = "sales-badge"
                                findAll {
                                    isNumeric
                                    small {
                                        withClass = "sales-badge-sign"
                                        findAll {
                                            eachText toContain "%"
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
```
