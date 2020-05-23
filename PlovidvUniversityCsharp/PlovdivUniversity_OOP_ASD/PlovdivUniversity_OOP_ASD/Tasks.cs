using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading;

namespace PlovdivUniversity_OOP_ASD
{
    class Tasks
    {

        public void CarRace()
        {
           
            List<CurrentCar> currentCarsOrderedBy = new List<CurrentCar>();
            Dictionary<string, int> currentRacerStats = new Dictionary<string, int>();
            



            string enterCarData = Console.ReadLine();
            string[] dataCollectedFromInut;
            while (!enterCarData.Equals("end", StringComparison.OrdinalIgnoreCase))
            {
                dataCollectedFromInut = enterCarData.Split("->");



                CurrentCar car;
                car = new CurrentCar(dataCollectedFromInut);

                if (!currentRacerStats.ContainsKey(car.DriverName))
                {
                    currentRacerStats.Add(car.DriverName, 0);
                }
                currentCarsOrderedBy.Add(car);
                enterCarData = Console.ReadLine();


            }

            DetermineWinnerByPoints(currentCarsOrderedBy, currentRacerStats);
            currentRacerStats.OrderByDescending(a => a.Value).ToDictionary(a => a.Key, a => a.Value);
            foreach(var item in currentRacerStats)
            {
                Console.WriteLine(item.Key+" "+item.Value);
            }


        }
        private void DetermineWinnerByPoints(List<CurrentCar> currentRacers, Dictionary<string, int> points)
        {
            currentRacers = currentRacers.OrderBy(a => a.Till100Boost).ToList();
            for (int i=0; i < currentRacers.Count; i++)
            {
                points[currentRacers[i].DriverName] += 3 * i;
            }



            currentRacers = currentRacers.OrderBy(a => a.After100Boost).ToList();
            for(int i = 0; i < currentRacers.Count; i++)
            {
                points[currentRacers[i].DriverName] += 3 * i;
            }
        }



        private struct CurrentCar
        {
            private string nameOfDriver;
            private string brand;
            private int horsePower;
            private double weight;
            private int till100Boost;
            private int after100Boost;



            public CurrentCar(params string[] currentCarData) :this()
            {

                this.DriverName = string.Concat(currentCarData[0]+" ", currentCarData[1]);    
            this.Brand = currentCarData[2];
            this.Weight = double.Parse(currentCarData[3]);
            this.HorsePower = int.Parse(currentCarData[4]);
            this.Till100Boost = this.HorsePower;
            this.After100Boost = this.HorsePower;
            this.ApplyBoost(currentCarData[5]);

                
            }
            private void ValidateBrand(string brand)
            {
                this.Brand = brand;
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
                    if (value <= 0)
                    {
                        throw new ArgumentException("Invalid Horse Powers");

                    }
                }
            }

            public int Till100Boost
            {
                get
                {
                    return this.till100Boost;

                }
                private set
                {
                    this.till100Boost = 1 / (value) * 1000 / 2;
                }
            }


            public int After100Boost
            {
                get
                {
                    return this.till100Boost;

                }
                private set
                {
                    this.after100Boost = 1 / (value) * 1000;
                }
            }

            public void ApplyBoost(string currentBoost)
            {
                switch (currentBoost.ToLower())
                {
                    case "do-100":

                        this.horsePower -= (this.horsePower / 100) * 30;
                        break;
                    case "do-200":
                        this.horsePower -= (this.horsePower / 100) * 20;
                        break;
                }
            }

            public string DriverName
            {
                get
                {
                    return this.nameOfDriver;
                }
                private set
                {
                    this.nameOfDriver = value;
                }
                    
            }


            public override string ToString()
            {
                return string.Format($"{this.Brand} {this.Weight}-weight {this.Till100Boost}-seconds for 100km/h and {this.after100Boost} for 200");

            }

        }
    }
}
