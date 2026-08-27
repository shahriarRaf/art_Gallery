# art_Gallery

Android gallery app for viewing, uploading, and browsing art content with Firebase-backed authentication and storage.

## What It Does

- Lets users register and log in with Firebase Authentication.
- Stores user profile data in Firebase Realtime Database.
- Uploads art images and captions to Firebase Storage and Realtime Database.
- Shows uploaded art in a RecyclerView with Glide image loading.
- Lists art by artist from a public JSON API.
- Opens external art resources from a curated list of websites.

## Tech Stack

- Android SDK
- Java
- Firebase Authentication
- Firebase Realtime Database
- Firebase Storage
- Volley
- Glide
- Material Components

## Main Screens

- `MainActivity` for login
- `RegistrationActivity` for new user signup
- `ControlFunction` for the main menu
- `UploadActivity1` and `UploadActivity2` for gallery browsing and uploads
- `EnterArtistName`, `ListOfArt`, and `DetailsOfArt` for artist-based browsing
- `LinkActivity` for external art websites
- `AboutActivity` for app information

## Project Diagram

See [MYARTGALLERY_DIAGRAM.md](MYARTGALLERY_DIAGRAM.md) for the Mermaid flowchart and service diagram.

## Setup

1. Open the project in Android Studio.
2. Sync Gradle dependencies.
3. Make sure `google-services.json` is present in the `app/` module.
4. Run the `app` configuration on an emulator or Android device.

## Notes

- The launcher activity is `MainActivity`.
- The app targets API 34 and uses a minimum SDK of 24.
- Internet access is required for Firebase and the external art API.