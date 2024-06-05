## Caloree
A simple app to fetch calorie details for food, built using Kotlin Multiplatform and a modularized architecture

## Prerequisites
To run the app from Android Studio on your local machine you'll need to add api_key value in your local.properties file

The API key can be generated from this [link](https://calorieninjas.com/api).
```
API_KEY = <YOUR_API_KEY>
```

## Architecture
The app has been built using a modularized layered architecture. The app has the following modules:
- **details** - feature module to handle logic related to a single calorie food details i.e has a viewmodel and composambles
- **calorees** - feature module to handle logic related to searched list of calorie food i.e has a viewmodel and composambles
- **designsystem** - shared lib which contains shared components between the feature modules
- **data** - shared lib which contains the implementation of selecting data between `local` and `network` modules.
- **local** - shared lib which contains logic for saving data to local device storage
- **network** - shared lib which contains logic for fetching data from network

##### Modularization Graph
```mermaid
%%{
  init: {
    'theme': 'base',
    'themeVariables': {"primaryTextColor":"#fff","primaryColor":"#5a4f7c","primaryBorderColor":"#5a4f7c","lineColor":"#f5a623","tertiaryColor":"#40375c","fontSize":"12px"}
  }
}%%

graph LR
  subgraph :core
    :core:data["data"]
    :core:designsystem["designsystem"]
    :core:network["network"]
    :core:local["local"]
  end
  subgraph :feature
    :feature:calorees["calorees"]
    :feature:details["details"]
  end
  :feature:calorees --> :core:data
  :feature:calorees --> :core:designsystem
  :composeApp --> :feature:calorees
  :composeApp --> :feature:details
  :core:data --> :core:network
  :core:data --> :core:local
  :feature:details --> :core:data
  :feature:details --> :core:designsystem
```
#### Libraries and tech stack
- [Kotlin](https://kotlinlang.org/) - programming language
- [Kotlin Multiplatform](https://www.jetbrains.com/kotlin-multiplatform/) - Multiplaform framework
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) - Declarative framework for sharing UIs across multiple platforms. Based on Kotlin and Jetpack Compose.
- [Koin](https://github.com/google/hilt](https://insert-koin.io/)) - a pragmatic lightweight dependency injection framework for Kotlin & Kotlin Multiplatform.
- [Ktor Client](https://ktor.io/) - networking client framework
- [KotlinX Serialization](https://github.com/Kotlin/kotlinx.serialization) - Serialization/Desirialization of JSON response from network.
- [KtLint](https://github.com/pinterest/ktlint) - Kotlin linter.
- [Room](https://developer.android.com/kotlin/multiplatform/room) - persistence library providing an abstraction layer over SQLite
  
#### CI/CD
- [Github Actions](https://github.com/kibettheophilus/caloree/tree/master/.github/workflows) - to run tests, run lint checks and assemble apk. The deployment workflows are WIP.

## Known Issues
- [BuildKonfig](https://github.com/kibettheophilus/caloree/issues/29) - buildKonfig config is generated on CI, it fails lint checks since it doens't conform to kotlin rules. Excluded `**/build/**` in ktlint but still facing the issue
- [Room](https://github.com/kibettheophilus/caloree/issues/23) - with the current setup, room doesn't save data. Another option will be to switch to [SqlDelight](https://github.com/cashapp/sqldelight) 

## Improvements
- UI/UX - improve the design of the app
