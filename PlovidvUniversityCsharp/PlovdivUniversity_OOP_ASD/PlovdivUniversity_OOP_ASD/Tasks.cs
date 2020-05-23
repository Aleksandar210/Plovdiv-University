using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace PlovdivUniversity_OOP_ASD
{
    class Tasks
    {

        public void CarRace()
        {
            Dictionary<string, Dictionary<string, CurrentCar>> currentRacers = new Dictionary<string, Dictionary<string, CurrentCar>>();

            string enterCarData = Console.ReadLine();
            while (!enterCarData.Equals("end", StringComparison.OrdinalIgnoreCase))
            {

            }
        }

        private struct CurrentCar
        {
            private string brand;
            private int horsePower;
            private double weight;
            private int till100Boost;
            private int after100Boost;

            public CurrentCar(params string[] currentCarData)
            {

            }

            public string Brand
            {
                get
                {
                    return this.brand;
                }
               private set
                {
                    this.brand = value;

                }
            }

            public double Weight
            {
                get
                {
                    return this.weight;
                }

                private set
                {
                    if (value <= 0)
                    {
                        throw new ArgumentException("Invali Weight");

                    }
                    else
                    {
                        this.Weight = value;
                    }
                }
            }

            public int HorsePower
            {
                get
                {
                    return this.HorsePower;

                }
                private set
                {

                }
            }

            public void ApplyBoost(string currentBoost)
            {

            }

        }
    }
}
