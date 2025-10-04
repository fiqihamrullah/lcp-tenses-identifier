# Left Corner Parsing for Tenses - Architecture Overview

## System Architecture


```
┌─────────────────────────────────────────────────────────────────┐
│                    USER INTERFACE LAYER                        │
├─────────────────────────────────────────────────────────────────┤
│  FrmIndentifikasiPT.java (Main GUI Window)                     │
│  - Input field for sentence                                    │
│  - Display table for tagged tokens                             │
│  - Result display for tense identification                     │
│  - Log area for parsing process                                │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                    PROCESSING LAYER                            │
├─────────────────────────────────────────────────────────────────┤
│  Kalimat.java (Sentence Model)                                 │
│  - Stores input sentence                                        │
│  - Manages list of tokens                                       │
│  - Provides token access methods                               │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                    NLP PROCESSING LAYER                        │
├─────────────────────────────────────────────────────────────────┤
│  Tagger.java                                                    │
│  - Uses Stanford POS Tagger                                     │
│  - Tokenizes and tags sentences                                 │
│  - Creates Token objects with symbols                          │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                    PARSING LAYER                               │
├─────────────────────────────────────────────────────────────────┤
│  LeftCornerParser.java                                          │
│  - Implements Left Corner parsing algorithm                    │
│  - Uses GrammarRule for parsing rules                          │
│  - Validates sentence structure                                │
│  - Provides parsing logs                                       │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                    TENSE IDENTIFICATION LAYER                  │
├─────────────────────────────────────────────────────────────────┤
│  TensesIdentifier.java                                          │
│  - Analyzes tagged tokens                                       │
│  - Identifies tense patterns                                    │
│  - Returns tense classification                                │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                    DATA MODEL LAYER                            │
├─────────────────────────────────────────────────────────────────┤
│  Token.java         │  Simbol.java    │  GrammarRule.java      │
│  - Word with POS    │  - Symbol       │  - Grammar rules       │
│  - Position info    │  - Type info    │  - Parsing patterns    │
│  - Symbol ref       │  - Name         │  - Rule mappings       │
└─────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────┐
│                    UTILITY LAYER                               │
├─────────────────────────────────────────────────────────────────┤
│  Util.java                                                      │
│  - Window positioning utilities                                │
│  - Look and feel management                                    │
└─────────────────────────────────────────────────────────────────┘
```

The system follows a **layered architecture** with clear separation of concerns:

```
┌─────────────────────────────────────────────────────────────┐
│                    Presentation Layer                       │
│                 (FrmIndentifikasiPT.java)                   │
└─────────────────────────────────────────────────────────────┘
                                │
┌─────────────────────────────────────────────────────────────┐
│                    Business Logic Layer                     │
│  ┌─────────────────┐  ┌─────────────────┐  ┌──────────────┐ │
│  │ LeftCornerParser│  │TensesIdentifier │  │  GrammarRule │ │
│  └─────────────────┘  └─────────────────┘  └──────────────┘ │
└─────────────────────────────────────────────────────────────┘
                                │
┌─────────────────────────────────────────────────────────────┐
│                    Data Access Layer                        │
│  ┌─────────────────┐  ┌─────────────────┐  ┌──────────────┐ │
│  │     Tagger      │  │    Kalimat      │  │    Token     │ │
│  └─────────────────┘  └─────────────────┘  └──────────────┘ │
└─────────────────────────────────────────────────────────────┘
                                │
┌─────────────────────────────────────────────────────────────┐
│                   External Dependencies                     │
│              (Stanford NLP Library)                        │
└─────────────────────────────────────────────────────────────┘
```

**Architecture Principles:**
- **Separation of Concerns**: Each layer handles specific responsibilities
- **Dependency Inversion**: High-level modules don't depend on low-level modules
- **Single Responsibility**: Each class has one reason to change
- **Open/Closed**: Open for extension, closed for modification

## Component Details

### Core Components

#### 1. **FrmIndentifikasiPT.java** - Main GUI Controller
- **Purpose**: User interface and application entry point
- **Responsibilities**: 
  - Handle user input/output
  - Coordinate parsing workflow
  - Display results and logging
- **Key Methods**: `jbtnDoParsingActionPerformed()`, `viewTable()`

#### 2. **LeftCornerParser.java** - Parsing Engine
- **Purpose**: Implements left-corner parsing algorithm
- **Responsibilities**:
  - Bottom-up token reduction
  - Top-down grammar validation
  - Parse tree construction
- **Key Methods**: `doLeftCornerParsing()`, `parse()`, `parseTopDown()`
- **Data Structures**: `Stack<Token> RHS`, `Stack<String> LHS`

#### 3. **TensesIdentifier.java** - Tense Classification
- **Purpose**: Identifies grammatical tenses in parsed sentences
- **Responsibilities**:
  - Analyze verb forms and auxiliary verbs
  - Classify tense types (8 categories)
  - Distinguish nominal vs verbal tenses
- **Key Methods**: `IsTense()`
- **Constants**: `PRESENT_TENSE_NOMINAL`, `PAST_TENSE_VERBAL`, etc.

#### 4. **Tagger.java** - POS Tagging Integration
- **Purpose**: Integrates with Stanford NLP for part-of-speech tagging
- **Responsibilities**:
  - Tokenize input sentences
  - Apply POS tags using Stanford MaxentTagger
  - Create Token objects with linguistic information
- **Key Methods**: `tokenizeAndTagKalimat()`
- **Dependencies**: Stanford NLP models

#### 5. **GrammarRule.java** - Grammar Definition
- **Purpose**: Defines context-free grammar rules for parsing
- **Responsibilities**:
  - Store grammar production rules
  - Provide symbol lookup functionality
  - Support grammar rule matching
- **Key Methods**: `getSimbolbyKey()`, `getSimbol()`
- **Data Structure**: `HashMap<String, String[]> mapphrase`

### Supporting Components

#### 6. **Kalimat.java** - Sentence Representation
- **Purpose**: Encapsulates sentence data and tokens
- **Responsibilities**: Store sentence text and tokenized words
- **Key Methods**: `tokenize()`, `getToken()`, `getTokenCount()`

#### 7. **Token.java** - Word Token
- **Purpose**: Represents individual words with linguistic information
- **Properties**: `name`, `symbol`, `position`
- **Key Methods**: `getName()`, `getSymbol()`, `getPosition()`

#### 8. **Simbol.java** - Grammar Symbol
- **Purpose**: Represents grammar symbols and POS tags
- **Properties**: `name`, `type`, `alias`
- **Key Methods**: `getName()`, `getType()`, `setName()`

## Processing Flow

### 1. Input Processing
```
User Input → FrmIndentifikasiPT → Kalimat Object
```
- User enters sentence in GUI text field
- Input validation and preprocessing
- Creation of Kalimat object

### 2. Tokenization & Tagging
```
Kalimat → Tagger → Stanford NLP → Tagged Tokens
```
- Sentence tokenization using `Kalimat.tokenize()`
- POS tagging with Stanford MaxentTagger
- Token object creation with linguistic metadata

### 3. Left-Corner Parsing
```
Tagged Tokens → LeftCornerParser → Grammar Validation → Parse Result
```

**Two-Phase Algorithm:**

**Phase A: Bottom-Up Reduction**
```java
// Reduce tokens to grammar symbols
while (!result.equals("Sentence")) {
    Simbol simbolbaru = grammarRule.getSimbol(simbol.getName());
    // Apply grammar rules from right to left
    // Build LHS stack
}
```

**Phase B: Top-Down Validation**
```java
// Validate against grammar rules
parseTopDown(listsimbol, level);
// Check grammatical correctness
// Ensure valid sentence structure
```

### 4. Tense Identification
```
Parsed Sentence → TensesIdentifier → Tense Classification
```
- Analyze verb forms and auxiliary verbs
- Apply tense detection patterns
- Return tense classification result

### 5. Result Display
```
Parse Result + Tense → GUI Display
```
- Update token table with POS tags
- Display parsing log
- Show tense identification result

## External Dependencies

### Stanford NLP Library
- **JAR File**: `stanford-postagger-3.4.1.jar`
- **Purpose**: Part-of-speech tagging and linguistic analysis
- **Models**: English language models in `models/` directory
  - `english-left3words-distsim.tagger`
  - `english-bidirectional-distsim.tagger`

### Java Runtime
- **Version**: Java 8+
- **Libraries**: 
  - Java Swing (GUI components)
  - Java Collections (Stack, HashMap, List)
  - Java I/O (File handling)

### Build Dependencies
- **Build Tool**: Apache Ant (build.xml)
- **IDE**: NetBeans project structure
- **Manifest**: JAR packaging configuration

## Key Features

### Parsing Capabilities
- **Left-Corner Algorithm**: Advanced parsing technique
- **Grammar Validation**: Context-free grammar rule checking
- **Error Handling**: Invalid sentence detection
- **Real-time Logging**: Step-by-step parsing visualization

### Tense Identification
- **8 Tense Categories**: Complete tense classification
- **Nominal/Verbal Distinction**: Precise tense form identification
- **Pattern Matching**: Verb form analysis
- **Comprehensive Coverage**: Present, Past, Future, Perfect tenses

### User Interface
- **Interactive GUI**: User-friendly interface
- **Real-time Analysis**: Live parsing feedback
- **Result Visualization**: Token table and parsing log
- **Error Reporting**: Clear error messages

## Grammar Rules

### Context-Free Grammar Definition
```
Sentence → S V O
S → NN | M | PRP | NNP
M → DT NN | DT NNS | NN NN | PRP$ NN
F → DT NN | DT NNS | DT JJS NN | NN NN | PRP$ NNP | PRP$ NN | JJ NN | DT JJ NN | NNP NNP
P → RB VBP | RB VB | RB VBZ | RB VBD | MD VB | VBP VBN | VBZ VBN
V → VBP | VBZ | VBD | P
A → DT RBS | DT JJ | RBS JJ | RB JJ
B → RB RB | RB NN
O → NN | PRP | RB | PRP RB | F | TO NN | RB NN | IN NN | IN NNP | IN F | TO F | A F | A | F F | F RB | DT F | PRP F
```

### Grammar Categories
- **S**: Subject (Noun Phrase)
- **V**: Verb (Verb Phrase)
- **O**: Object (Noun Phrase)
- **M**: Modified Noun Phrase
- **F**: Full Noun Phrase
- **P**: Verb Phrase with modifiers
- **A**: Adjective Phrase
- **B**: Adverb Phrase

## Tense Identification Patterns

### Verb Form Patterns
```java
// Past Tense Markers
VBD: "was", "were" → PAST_TENSE_NOMINAL
VBD: other verbs → PAST_TENSE_VERBAL

// Present Tense Markers  
VBP/VBZ/VB: "am", "is", "are" → PRESENT_TENSE_NOMINAL
VBP/VBZ/VB: other verbs → PRESENT_TENSE_VERBAL

// Perfect Tense Markers
VBN: "been" → PRESENT_PERPECT_NOMINAL
VBN: other verbs → PRESENT_PERPECT_VERBAL

// Future Tense Markers
MD: "will", "shall" + "be" → FUTURE_TENSE_NOMINAL
MD: "will", "shall" + other verbs → FUTURE_TENSE_VERBAL
```

### Tense Categories
1. **PRESENT_TENSE_NOMINAL** (1)
2. **PRESENT_TENSE_VERBAL** (2)
3. **PRESENT_PERPECT_NOMINAL** (3)
4. **PRESENT_PERPECT_VERBAL** (4)
5. **PAST_TENSE_NOMINAL** (5)
6. **PAST_TENSE_VERBAL** (6)
7. **FUTURE_TENSE_NOMINAL** (7)
8. **FUTURE_TENSE_VERBAL** (8)
9. **UNIDENTIFIED_TENSE** (0)

## File Structure

```
leftcornerparsingfortenses/
├── src/leftcornerparsingfortenses/          # Source code
│   ├── FrmIndentifikasiPT.java             # Main GUI application
│   ├── FrmIndentifikasiPT.form             # GUI form definition
│   ├── LeftCornerParser.java               # Core parsing engine
│   ├── TensesIdentifier.java               # Tense classification
│   ├── Tagger.java                         # POS tagging integration
│   ├── GrammarRule.java                    # Grammar definition
│   ├── Kalimat.java                        # Sentence representation
│   ├── Token.java                          # Word token
│   ├── Simbol.java                         # Grammar symbol
│   └── Leftcornerparsingfortenses.java     # Main class
├── src/utils/                              # Utility classes
│   └── Util.java                           # Utility functions
├── models/                                 # Stanford NLP models
│   ├── english-left3words-distsim.tagger
│   ├── english-bidirectional-distsim.tagger
│   └── README-Models.txt
├── libs/                                   # External libraries
│   └── stanford-postagger-3.4.1.jar
├── build/                                  # Compiled classes
│   └── classes/leftcornerparsingfortenses/
├── nbproject/                              # NetBeans project files
│   ├── build-impl.xml
│   ├── project.properties
│   └── private/
├── build.xml                               # Ant build script
├── manifest.mf                             # JAR manifest
└── README.md                               # Project documentation
```

## Build Configuration
### NetBeans Project Configuration
- **Project Type**: Java Application
- **Build Tool**: Apache Ant
- **IDE**: NetBeans
- **Java Version**: 8+
- **Main Class**: `leftcornerparsingfortenses.FrmIndentifikasiPT`

### Dependencies Configuration
- **Classpath**: Includes Stanford NLP JAR
- **Models**: English language models in `models/` directory
- **Manifest**: JAR packaging with main class specification

 