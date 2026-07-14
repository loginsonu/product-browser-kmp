# Product Browser (Kotlin Multiplatform)

A Kotlin Multiplatform (KMP) application built using **Compose Multiplatform** that demonstrates Clean Architecture, MVVM, API integration using Ktor, and type-safe navigation. The application allows users to browse products, view detailed product information, and search products using a remote API.

The project shares business logic, networking, and UI between Android and iOS through Kotlin Multiplatform.

---

# Business Requirements

This project fulfills the following business requirements:

- Display a list of products retrieved from a remote API.
- View detailed information about a selected product.
- Search products by keyword using API-based search.
- Support Android and iOS using Kotlin Multiplatform.
- Implement business use cases.
- Include unit testing for business logic.

---

# Features

- Product Listing
- Product Details
- API-based Product Search
- Debounced Search Requests
- Loading State
- Error State
- Empty State
- Type-safe Navigation
- Shared UI using Compose Multiplatform
- Unit Tested Business Logic

---

# Tech Stack

- Kotlin Multiplatform
- Compose Multiplatform
- Kotlin Coroutines
- StateFlow
- Ktor Client
- Kotlin Serialization
- Navigation Compose
- Coil 3
- Material 3
- Clean Architecture
- MVVM

---

# Project Architecture

The project follows **Clean Architecture** with the **MVVM** design pattern.

```
Presentation
        │
        ▼
     ViewModel
        │
        ▼
     Use Cases
        │
        ▼
 Repository Interface
        │
        ▼
Repository Implementation
        │
        ▼
      Remote API
```

### Presentation Layer

Responsible for rendering UI, handling user interactions and observing ViewModel state using StateFlow.

### Domain Layer

Contains business models, repository contracts and business use cases.

### Data Layer

Responsible for communicating with the remote API, mapping DTOs to domain models and implementing repository interfaces.

### Core Layer

Contains common utilities including networking configuration, dependency injection and result handling.

---

# Project Structure

```
shared
│
├── core
│   ├── di
│   ├── network
│   └── result
│
├── data
│   ├── remote
│   │   ├── api
│   │   ├── dto
│   │   └── mapper
│   └── repository
│
├── domain
│   ├── model
│   ├── repository
│   └── usecase
│
├── presentation
│   ├── components
│   ├── navigation
│   ├── preview
│   ├── productdetail
│   ├── productlist
│   ├── search
│   └── theme
│
└── commonTest
```

---

# Business Use Cases

The application contains the following business use cases:

- GetProductsUseCase
- GetProductDetailUseCase
- SearchProductsUseCase

---

# API

The application uses the **DummyJSON API**.

Base URL

```
https://dummyjson.com/
```

Endpoints used

```
GET /products

GET /products/{id}

GET /products/search?q=
```

---

# Build and Run

## Android

### Requirements

- Android Studio (Latest Stable Version)
- JDK 17 or later

### Steps

1. Clone the repository.

```bash
git clone https://github.com/loginsonu/product-browser-kmp.git
```

2. Open the project in Android Studio.

3. Allow Gradle Sync to complete.

4. Select the **androidApp** run configuration.

5. Run on an emulator or physical Android device.

---

## iOS

### Requirements

- macOS
- Xcode
- Kotlin Multiplatform Plugin

### Steps

1. Open the project on macOS.

2. Build the shared module.

3. Open the iOS application in Xcode.

4. Run on an iPhone Simulator or physical device.

The shared module has been successfully compiled for the iOS Simulator target (`iosSimulatorArm64`).

---

# Platform Verification

The application has been successfully verified on both Android and iOS platforms.

### Android

- ✅ Application tested locally on Android.
- ✅ All core features verified:
  - Product Listing
  - Product Details
  - API-based Search

### iOS

The iOS application has been validated through GitHub Actions CI.

The workflow performs the following automated steps:

- Builds the iOS application using Xcode.
- Boots an iPhone Simulator.
- Installs the generated application.
- Launches the application successfully.
- Records a demo video of the running application.
- Uploads the demo video as a CI artifact.
- Executes Kotlin Multiplatform shared module tests on the iOS Simulator.

This verifies that the shared Compose Multiplatform application successfully builds and runs on iOS.

---

# Continuous Integration

The project includes a GitHub Actions workflow for automated iOS verification.

The workflow automatically:

- Builds the iOS application.
- Runs Kotlin Multiplatform shared module tests.
- Verifies successful application launch on the iOS Simulator.
- Generates and uploads a demo video as a build artifact.

This helps ensure that the application remains buildable and functional across supported platforms.

---

# Unit Testing

The project includes unit testing for the business layer.

Implemented test:

- GetProductsUseCaseTest

The repository dependency is replaced with a fake implementation to verify the business logic in isolation.

---

# Design Decisions

### Clean Architecture

Business logic is separated from presentation and networking to improve maintainability and testability.

### MVVM

ViewModels expose immutable UI state using StateFlow while keeping business logic outside the UI.

### Manual Dependency Injection

A lightweight `AppContainer` is used to provide dependencies instead of a dependency injection framework such as Hilt or Koin. This keeps the project simple while maintaining loose coupling.

### Repository Pattern

The Repository pattern abstracts the remote API from the domain layer.

### API-based Search

Search functionality uses the server-side API endpoint instead of filtering locally, matching the assignment requirements.

### Debounced Search

Search requests are debounced to reduce unnecessary network calls while the user is typing.

### Type-safe Navigation

Navigation Compose type-safe destinations are used to reduce runtime navigation errors and improve navigation safety.

---

# Trade-offs / Assumptions

- Product information is always fetched from the remote API.
- Local caching was not implemented to keep the scope focused on the required functionality.
- Manual dependency injection was chosen over a DI framework to reduce project complexity.
- Search uses the server-side API provided by DummyJSON instead of local filtering.
- The project was verified on Android and the shared module was successfully compiled for the iOS Simulator target.

---

# Future Improvements

- Offline caching using SQLDelight
- Product category filtering
- Pagination
- Pull-to-refresh
- Favorites
- Dependency Injection using Koin
- Enhanced animations
- Improved UI customization

---

# Author

Sony Kumar Sharma