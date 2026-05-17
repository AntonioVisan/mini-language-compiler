# Mini Language Compiler

Custom mini-language compiler implemented in C# using ANTLR4.

## Features

- Lexer and parser generation using ANTLR4
- Custom grammar definition (`MiniLanguage.g4`)
- Semantic analysis with symbol tables
- Type checking and semantic validation
- Detection of semantic errors:
  - duplicate declarations
  - undefined identifiers
  - invalid function calls
- Visitor-based AST traversal

## Technologies

- C#
- ANTLR4
- .NET Framework

## Project Structure

- `MiniLanguage.g4` — grammar definition
- `SemanticChecker.cs` — semantic validation logic
- `FunctionVisitor.cs` — function processing
- `StatementVisitor.cs` — statement traversal
- `ExpressionTypeVisitor.cs` — expression type analysis
- `LexerErrorListener.cs` / `ParserErrorListener.cs` — custom error handling

## Example Concepts Implemented

- Variables
- Functions
- Symbol tables
- Type validation
- Semantic error reporting

## Run

Open the solution file in Visual Studio and build the project.
