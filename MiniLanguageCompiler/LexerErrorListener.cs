using Antlr4.Runtime;
using System.Collections.Generic;
using System.IO;

namespace MiniLanguageCompiler
{
    internal class LexerErrorListener : IAntlrErrorListener<int>
    {
        public List<string> errors { get; } = new List<string>();
        public void SyntaxError(
            TextWriter output, 
            IRecognizer recognizer, 
            int offendingSymbol, 
            int line, 
            int charPositionInLine, 
            string msg, 
            RecognitionException e)
        {
            errors.Add($"Lexical error at line {line}: {msg}");
        }
    }
}
