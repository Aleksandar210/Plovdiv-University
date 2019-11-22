// wednesdayFever.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include<iostream>
#include<string>
#include<cmath>
using namespace std;

int numberMaxElem(double anArray[],  int size)
{
	int count = 0;
	double max;
	for (int i = 0; i < size; i++){
		if (anArray[i] < anArray[i + 1]){
			swap(anArray[i], anArray[i + 1]);

		}
	}

		//checking how many elemtns are the same as the max one
		for (int j = 0; j < size; j++){
			max = anArray[0];
			if (anArray[j] == max){
				count++;
			}
		}
		return count;
	}



int lastNegative(double arr[],   int size){
	int index = 0;
	int count = 0;
	bool positive = true;
	for (int i = 0; i < size; i++){
		count++;
		if (arr[i] <0){
			positive = false;
			index = count-1;
		}
		
		if (positive == true){
			index = -1;
		}
		
	}
	return index;
}





int main()
{
	int size;
		cout << "enter size ";
		cin >> size;


		double* anArray = new double[size];
		for (int i = 0; i < size; i++){
			cin >> anArray[i];

		}
	cout<<numberMaxElem(anArray,size );
	delete[] anArray;


	//double array[10] = { 1, 2, 3, 4, -6, 3, 2, -1, 2, 1 };
	//double array1[10] = { 1, 2, 3, -7, 3, 4, 2, 4, 5, 6 };
	//double array3[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
	

	
	return 0;
}

