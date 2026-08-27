# MyArtGallery App Diagram

This document summarizes the app structure and the main runtime flows in the project.

## App Overview

MyArtGallery is an Android app that uses Firebase Authentication, Firebase Realtime Database, Firebase Storage, Volley, and Glide.

## Screen Flow

```mermaid
flowchart TD
    A[MainActivity\nLogin Screen] -->|Register| B[RegistrationActivity]
    A -->|Login success| C[ControlFunction]

    B --> D[(Firebase Auth)]
    B --> E[(Firebase Realtime Database\nuser)]

    C --> F[UploadActivity1\nGallery List]
    C --> G[LinkActivity\nExternal Art Links]
    C --> H[EnterArtistName]
    C --> I[AboutActivity]
    C --> A

    F --> J[UploadActivity2\nImage Upload Form]
    J --> K[(Firebase Storage)]
    J --> L[(Firebase Realtime Database\nImages)]
    K --> J
    L --> F

    H --> M[ListOfArt]
    M --> N[DetailsOfArt]

    G --> O[Browser / External Art Sites]
```

## Data And Service Diagram

```mermaid
flowchart LR
    subgraph Android App
        A1[MainActivity]
        A2[RegistrationActivity]
        A3[ControlFunction]
        A4[UploadActivity1]
        A5[UploadActivity2]
        A6[EnterArtistName]
        A7[ListOfArt]
        A8[DetailsOfArt]
        A9[LinkActivity]
        A10[AboutActivity]
        A11[MyAdapter]
        A12[DataClass]
        A13[User]
    end

    Auth[(Firebase Auth)]
    DB[(Firebase Realtime Database)]
    Storage[(Firebase Storage)]
    Api[(Public JSON API\nmyjson.online)]
    Glide[(Glide)]
    Volley[(Volley)]

    A1 --> Auth
    A2 --> Auth
    A2 --> DB
    A5 --> Storage
    A5 --> DB
    A4 --> DB
    A4 --> A11
    A11 --> Glide
    A7 --> Volley
    A7 --> Api
    A7 --> A8
    A6 --> A7
    A9 --> Browser[(External websites)]
    A10 --> Raw[(Raw resource text)]
    A12 --> DB
    A13 --> DB
```

## Main Data Models

- `User`: stores registration data such as name, email, date of birth, gender, and password.
- `DataClass`: stores uploaded art image URLs and captions.

## Notes

- `MainActivity` is the launcher screen.
- `ControlFunction` is the main menu after login.
- `UploadActivity2` uploads images to Firebase Storage, then saves the download URL and caption to Realtime Database.
- `ListOfArt` fetches artist data from a remote JSON API and opens `DetailsOfArt` for the selected item.
