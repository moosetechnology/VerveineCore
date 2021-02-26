# VerveineCore

![Deprecated](https://img.shields.io/badge/Deprecated-FAMIX%20Compatibility-red)

This repository work with [VerveineJ V1](https://github.com/moosetechnology/VerveineJ/tree/v1).
It includes the FAMIX compatibility metamodel.

## Installation

You only need to clone the repository to install it.
Then, we use maven for the compilation, the dependencies, and the packaging.

## Usage

Packaging with maven will create an archive with the code.
Then, rename this archive `famix.jar`, and replace the one of VerveineJ with the new created one (under the lib folder).

```shell script
mvn package
```
