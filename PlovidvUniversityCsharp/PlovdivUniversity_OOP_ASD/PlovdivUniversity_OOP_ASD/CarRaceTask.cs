using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class CarRaceTask
    {

        public void CarRace()
        {
            Dictionary<string, int> currentStats = new Dictionary<string, int>();
            List<Car> currentRacers = new List<Car>();
            string enterCarData = Console.ReadLine();
            string[] data;
            while (!enterCarData.Equals("end"))
            {
                data = enterCarData.Split("->");
                if(!currentStats.ContainsKey(string.Concat(data[0]+" "+ data[1])))
                {
                    currentStats.Add(string.Concat(data[0] + " " + data[1]), 0);
                    currentRacers.Add(new Car(data));
                }
                enterCarData = Console.ReadLine();
            }

        
            currentRacers.Sort((a,b)=>a.HorsePower.CompareTo(b.HorsePower));

            DetermineWinnerByPoints(currentRacers, currentStats);
           currentStats =  currentStats.OrderByDescending(a => a.Value).ToDictionary(a => a.Key, a => a.Value);
            foreach(var item in currentStats)
            {
                Console.WriteLine(item.Key + " " + item.Value);

            }

        }




        private void DetermineWinnerByPoints(List<Car> currentRacers, Dictionary<string, int> points)
        {
            while (currentRacers.Count != 0)
            {
                Car currentRacer = currentRacers[0];
                currentRacers.RemoveAt(0);
                for (int i = 0; i < currentRacers.Count; i++)
                {
                    Battle(currentRacer, currentRacers[i], points);

                }
            }
        }





        private void Battle(Car racer1, Car racer2, Dictionary<string, int> points)
        {
            if (racer1.To100 < racer2.To100)
            {
                points[racer1.DriverNames] += 3;
            }
            else
            {
                points[racer2.DriverNames] += 3;
            }

            if (racer1.To100 < racer2.To100 && racer1.After100 < racer2.After100)
            {
                points[racer1.DriverNames] += 3;
            }
            else
            {
                points[racer2.DriverNames] += 3;
            }

        }




    }

       
        

     
    }





    internal class Car
    {
        private string nameOfDriver;
        private string brand;
        private int horsePower;
        private double weight;
      
        
        

        public Car(params string[] currentData)
        {
            this.DriverNames = currentData[0] + " " + currentData[1];

            this.Brand = currentData[2];
            this.Weight = double.Parse(currentData[3]);
            this.HorsePower = int.Parse(currentData[4]);
            this.To100 = CalculateSecondsTo100(this.HorsePower);
            this.After100 = CalculateSecondsAfter100(this.HorsePower);
            this.ApplyBoost(currentData[5]);
           

        }

        public string DriverNames
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

        public string Brand
        {
            get
            {
                return this.brand;
            }
          private  set
            {
                this.brand = value;
            }
        }

       

        public int HorsePower
        {
            get
            {
                return this.horsePower;
            }
          private  set
            {
                this.horsePower = value;
            }
        }

        public double Weight
        {
            get
            {
                return this.weight;
            }
          private  set
            {
                this.weight = value;
            }
        }
        public double To100 { get; private set; }
       

        private double CalculateSecondsTo100(int horsePower)
        {
            return ((1 / (double)horsePower) * 1000) / 2;
        }

        public double After100 { get; private set; }
        

        private double CalculateSecondsAfter100(int horsePower)
        {
            return (1 / (double)horsePower) * 1000;
        }

        private void ApplyBoost(string currentBoost)
        {
            switch (currentBoost)
            {
                case "do-100":

                    this.To100 =  this.To100 - ((this.To100 * 30) / 100);
                    break;
                case "do-200":
                    this.After100 = this.After100 - ((this.After100 * 20) / 100);
                    break;
            }
        }

        public override string ToString()
        {
            return string.Format($"");
        }
    }

