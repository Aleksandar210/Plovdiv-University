using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class ASD_Tasks
    {



        //task2
        //----------------------------------------------------------------------------------

        private void ProductTask()
        {
            Dictionary<string, int> currentProducts = new Dictionary<string, int>();
            string enterProduct = Console.ReadLine();
            string[] data;
            while (!enterProduct.Equals("end"))
            {
                data = enterProduct.Split();
                if (!currentProducts.ContainsKey(data[0]))
                {
                    currentProducts.Add(data[0], int.Parse(data[1]));
                }
                else
                {

                }
            }
        }

        //-------------------------------------------------------------------------------

        //task 3 Word Odd repeat
        //--------------------------------------------------------------------------------
        public void RepeatenceWords()
        {
            string enterText = Console.ReadLine();
            string[] currentWords = enterText.Split();
            Dictionary<string, int> currentWordsCount = new Dictionary<string, int>();
            foreach(var item in currentWords)
            {
                if (!currentWordsCount.ContainsKey(item.ToLower()))
                {
                    currentWordsCount.Add(item, 1);
                }
                else
                {
                    currentWordsCount[item.ToLower()] += 1;
                }
            }
            currentWordsCount = currentWordsCount.Where(e => e.Value % 2 != 0).ToDictionary(e => e.Key, e => e.Value);
            foreach(var item in currentWordsCount)
            {
                Console.WriteLine(item.Key);
            }
        }



        //task1
        //---------------------------------------------------------------------------------------------------------------

        public void MatrixMinElements()
        {
            int[][] currentMatrix  =  new int[5][];
            int[] finalResutArray = new int[5];
            
            string addNumbers;
            for(int i = 0; i < 5; i++)
            {
                addNumbers = Console.ReadLine();
                for(int j = 0; j < 5; j++)
                {
                    currentMatrix[i] = FixNumberAdding(addNumbers);
                }
            }
            int k = SmallestElemOfAll(currentMatrix);
            Dictionary<int, int> currentRowSmallestElemPosition = new Dictionary<int, int>();
            FindRowColPosCurrentSmall(currentRowSmallestElemPosition, currentMatrix);
            
            for(int i = 0; i < 5; i++)
            {
                finalResutArray[i] = i - (currentRowSmallestElemPosition[i] * k);
            }

            foreach(var item in finalResutArray)
            {
                Console.Write(item + " ");
            }
        }

        private void FindRowColPosCurrentSmall(Dictionary<int,int> current,int[][] currentMatrix)
        {
            for(int i = 0; i < 5; i++)
            {
                int minElem = 0;
                current.Add(i, 0);
                for(int j = 0; j < 5; j++)
                {
                    if (currentMatrix[i][j] < minElem)
                    {
                        minElem = currentMatrix[i][j];
                        current[i] = minElem;
                    }
                }
            }
        }

        private int SmallestElemOfAll(int[][] currentMatrix)
        {
            int smallestElem = 0;
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    if (currentMatrix[i][j] < smallestElem)
                    {
                        smallestElem = currentMatrix[i][j];
                    }
                }
            }
            return smallestElem;

        }

        private  int[] FixNumberAdding(string addedNumbers)
        {
            Random rand = new Random();
            int[] current = addedNumbers.Split().Select(e=>int.Parse(e)).ToArray();
            int[] numbersLine = new int[5];
            if (current.Length > 5)
            {
                Array.Copy(current, numbersLine, 5);
            }
            else if (current.Length < 5)
            {
                int neededNumbersToAdd = 5 - current.Length;
                
                Array.Copy(current, numbersLine, current.Length);
                for(int i = current.Length; i <= neededNumbersToAdd+1; i++)
                {
                    numbersLine[i] = rand.Next(0, int.MaxValue);
                }
            }
            else if (current.Length == 1)
            {
                numbersLine[0] = current[0];
                for(int i = 1; i < numbersLine.Length; i++)
                {
                    numbersLine[i] = rand.Next(1, int.MaxValue);
                }
            }
            else if (current.Length == 5)
            {
                return current;
            }
            else
            {
                for (int i = 0; i < numbersLine.Length; i++)
                {
                    numbersLine[i] = rand.Next(1, int.MaxValue);
                }
            }

            return numbersLine;
        }
        //-------------------------------------------------------------------------------------------------------------------------------------


      
            //task 4
            //-------------------------------------------------------------------------------------------------
        private void ArrayManipulationWithMethods()
        {
            Random rand = new Random();
            int[] currentArray = new int[10];
            for(int i = 0; i < currentArray.Length; i++)
            {
                currentArray[i] = rand.Next(0, int.MaxValue);
            }
            Console.WriteLine("Average Value = " + AverageArrayValue(currentArray));
            Console.Write("Enter number to check if its in Array: ");
            int number = int.Parse(Console.ReadLine());
            Console.WriteLine(CheckIfNumberIsInArray(number, currentArray));
            Console.WriteLine("Second Smallest Number: " + FindSecondSmallestNumber(currentArray));
            int[] newArray = new int[10];
            Console.WriteLine("New Array before transfering data");
            foreach(var item in newArray)
            {
                Console.Write(item + " ");

            }
            TransferDataBetweenArrays(currentArray, newArray);
            Console.WriteLine("After transfer");
            foreach (var item in newArray)
            {
                Console.Write(item + " ");

            }
        }


        private void TransferDataBetweenArrays(int[] currentArray, int[] arrayToTransferIn)
        {
            Array.Copy(currentArray, arrayToTransferIn, currentArray.Length);


        }


        private int FindSecondSmallestNumber(int[] currentArray)
        {
            Array.Sort(currentArray);
            int smallest = currentArray[0];
            for(int i = 1; i <= currentArray.Length; i++)
            {
                if (currentArray[i] < smallest)
                {
                    return currentArray[i];
                }
            }

            return -1;

        }

        private bool CheckIfNumberIsInArray(int number, int[] currentArray)
        {
            bool isIn = false;
            for(int i = 0; i < currentArray.Length; i++)
            {
                if (currentArray[i] == number)
                {
                    return true;
                }
            }

            return isIn;

        }


        private int AverageArrayValue(int[] currentArray)
        {
            int average = 0;
            for(int i = 0; i < currentArray.Length; i++)
            {
                average += currentArray[i];
            }

            return average /= currentArray.Length;


        }

        //-------------------------------------------------------------------------------------------------------------

    }
}
