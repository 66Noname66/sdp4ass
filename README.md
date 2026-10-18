# Assignment #4 — Facade Pattern

Course Information
Course: Software Design Patterns
Assignment: #4 — Facade Pattern
Student: Damir Seipenov
Group: SE-2523

## 1. Project Description

This project demonstrates the Facade structural design pattern using a simplified media conversion system.

The system provides a single, simple interface for converting media files between supported formats. Instead of interacting with multiple subsystem classes directly, the client calls one method provided by `MediaConversionFacade`.

The program simulates the media conversion process and writes processed sample data to an output file. It does not perform real audio encoding.

## 2. Project Objectives

Understand the purpose of the Facade design pattern.
Implement a facade that simplifies access to a complex subsystem.
Separate responsibilities between subsystem classes.
Reduce coupling between the client and subsystem.
Demonstrate how multiple classes can work together through a unified interface.

## 3. Project Structure

```text
FacadePatternAssignment/
├── src/
│   ├── Main.java
│   ├── MetadataReader.java
│   ├── CodecFactory.java
│   ├── BitrateReader.java
│   ├── AudioMixer.java
│   └── MediaConversionFacade.java
└── README.md
```

## 4. Class Descriptions

Main.java
The client class. It creates a `MediaConversionFacade` object and calls the `convert()` method without accessing subsystem classes directly.

MetadataReader.java
Detects the source file format from its extension and generates simulated file metadata.

CodecFactory.java
Checks supported formats and selects the corresponding codec. Supported formats are MP3, WAV, and OGG.

BitrateReader.java
Reads simulated audio data and processes the byte array.

AudioMixer.java
Prepares the output data by adding a header containing the target format.

MediaConversionFacade.java
The main facade class. It coordinates metadata reading, codec selection, data processing, output preparation, and file writing through a single public method.

## 5. How to Run the Project

 Requirements

Java Development Kit (JDK) 17
IntelliJ IDEA or another Java IDE

Instructions

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 17 is configured.
3. Ensure all six Java files are located in the same source package.
4. Open `Main.java`.
5. Run the `main()` method.
6. Check the console output and the generated output file.


## 6. Example Usage


MediaConversionFacade converter =
        new MediaConversionFacade();

String outputFile = converter.convert("song.wav", "mp3");


The program processes the simulated audio data and creates an output file named:

song_converted.mp3

 ## 7. Expected Output

MetadataReader: Detected format: wav
MetadataReader: Title: song.wav, Duration: 180 seconds
CodecFactory: Selected WAV Codec
CodecFactory: Selected MP3 Codec
BitrateReader: Read audio data
BitrateReader: Processed audio using WAV Codec
AudioMixer: Prepared output for MP3
Conversion completed successfully.
Output file: song_converted.mp3

The actual output includes the number of bytes read and the size of the generated file.

 ## 8. Design Pattern Explanation

The Facade pattern provides a simplified interface to a complex subsystem.

In this project, `MediaConversionFacade` hides the internal details of the conversion process. The client only needs to call `convert(fileName, targetFormat)`.

The facade coordinates the subsystem classes in the correct order. Each subsystem class has a specific responsibility, making the program easier to understand and maintain.

Advantages

 Simplifies interaction with multiple classes.
 Reduces coupling between the client and subsystem.
 Centralizes the conversion workflow.
 Keeps subsystem responsibilities separate.
 Makes the client code easier to read.

## 9. Conclusion

This project demonstrates the implementation of the Facade structural design pattern in Java 17. The `MediaConversionFacade` provides a unified interface to several collaborating classes, simplifying the simulated media conversion process.

The client interacts only with the facade, while the internal subsystem operations remain hidden behind its interface.

The implementation illustrates the main purpose of the Facade pattern: reducing complexity and making a subsystem easier to use.
