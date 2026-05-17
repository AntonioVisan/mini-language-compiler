using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tema_2_LFC
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
