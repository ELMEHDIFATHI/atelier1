using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using compte_persone;


namespace compte_persone
{
    class Program
    {
        static void Main(string[] args)
        {
            personne p = new personne("mehdi","fathi","casa");
            compte c = new compte(150000, p);

            personne p2 = new personne("ayoub", "fathi", "casa");
            compte c2 = new compte(1500, p);

            c.print();
            c2.print();

           // c2.ajouter_solde(500);
           // c2.retire_solde(500);
          

           // c2.print();
            //Console.WriteLine("ici c est le compte de mehdi");

            //  c.retire_solde(1000);
            // c.print();

            compte.virement(c, c2, 1000);
             c2.print();
            c.print();



            Console.ReadKey();
        }
    }
}
