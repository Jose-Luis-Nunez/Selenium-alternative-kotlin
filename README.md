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
    .
    .
    .
}
```
