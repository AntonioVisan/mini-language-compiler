using Antlr4.Runtime;
using System.Collections.Generic;
using System.IO;

namespace MiniLanguageCompiler
{
    internal class ParserErrorListener : IAntlrErrorListener<IToken>
    {
        public List<string> errors { get; } = new List<string>();

        public void SyntaxError(
            TextWriter writer, 
            IRecognizer recognizer,
            IToken offendingSymbol, 
            int line, 
            int charPositionInLine, 
            string msg, 
            RecognitionException e)
        {
            errors.Add($"Syntax error at line {line}: {msg}");
        }
    }
}
