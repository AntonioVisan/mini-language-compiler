namespace MiniLanguageCompiler
{
    internal class Variable
    {
        public string name { get; set; }
        public string type { get; set; }
        public dynamic value { get; set; }
        
        public bool IsConst { get; set; }

        public bool IsParameter { get; set; }
    }
}
