# art_Gallery

Android art gallery app for browsing, uploading, and discovering artwork with Firebase-backed authentication and storage.

## Overview

MyArtGallery combines login, registration, image upload, artist lookup, and external gallery browsing in one Android app.

## Highlights

- Firebase Authentication for user sign-up and login.
- Firebase Realtime Database for storing user profiles and uploaded art metadata.
- Firebase Storage for image uploads.
- RecyclerView gallery rendering with Glide.
- Artist-based browsing from a public JSON API.
- Curated links to external art websites.

## Tech Stack

- Android SDK
- Java
- Firebase Authentication
- Firebase Realtime Database
- Firebase Storage
- Volley
- Glide
- Material Components

## Key Screens

- `MainActivity` for login
- `RegistrationActivity` for account creation
- `ControlFunction` for the main menu
- `UploadActivity1` and `UploadActivity2` for viewing and uploading art
- `EnterArtistName`, `ListOfArt`, and `DetailsOfArt` for artist browsing
- `LinkActivity` for external art resources
- `AboutActivity` for app information

## Project Diagram

See [MYARTGALLERY_DIAGRAM.md](MYARTGALLERY_DIAGRAM.md) for the Mermaid flowchart and service diagram.

## Getting Started

1. Open the project in Android Studio.
2. Sync Gradle dependencies.
3. Confirm `google-services.json` is present in the `app/` module.
4. Run the `app` configuration on an emulator or Android device.

## Repository Notes

- The launcher activity is `MainActivity`.
- The app targets API 34 and uses a minimum SDK of 24.
- Internet access is required for Firebase and the external art API.