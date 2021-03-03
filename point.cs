using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace point.net
{
    class point
    {
        private double x;
        private double y;



        public point(double x,double y)
        {
            this.x = x;
            this.y = y;

        }


        public void afficher()
        {
            Console.WriteLine("le premeiere point :"+this.x+"le 2 eme point :"+this.y);
        }

        public void traslate(double a,double b)
        {
            this.x = a;
            this.y = b;
        }


        public double distance(point p)
        {
            double dis = Math.Sqrt(Math.Pow((this.x-p.x),2)+ Math.Pow((this.x - p.x), 2));

            return dis;
        }

        public point milieu(point p)
        {
            point po = new point(0,0);

             po.x = (this.x - p.x) / 2;
            po.y = (this.y - p.y) / 2;


            return po;
        }
    }
}
