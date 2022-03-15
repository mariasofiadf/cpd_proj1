class MatrixProduct{  
    public static void main(String args[]){  
        int side = 1500;
        OnMult(side,side);
        OnMultLine(side,side);
    }  

    public static void OnMult(int m_ar, int m_br){
        
        //creating 3 matrices    
        double[] pha =new double[m_ar*m_br]; 
        double[] phb =new double[m_ar*m_br]; 
        double[] phc =new double[m_ar*m_br];   
        double temp; 
	    int i, j, k;
            
        //filling matrix A
        for(i=0; i<m_ar; i++)
            for(j=0; j<m_ar; j++)
                pha[i*m_ar + j] = (double)1.0;

        //filling matrix B
        for(i=0; i<m_br; i++)
            for(j=0; j<m_br; j++)
                phb[i*m_br + j] = (double)(i+1);


        double Time1, Time2;

        Time1 = System.nanoTime();
        //Product Calculation
        for(i=0; i<m_ar; i++)
        {	for( j=0; j<m_br; j++)
            {	temp = 0;
                for( k=0; k<m_ar; k++)
                {	
                    temp += pha[i*m_ar+k] * phb[k*m_br+j];
                }
                phc[i*m_ar+j]=temp;
            }
        }

        Time2 = System.nanoTime();

        double TimeElapsed = (Time2-Time1)/(Math.pow(10,9));

        System.out.println("Time: " + TimeElapsed + " seconds");

        //Output Result Matrix
        for(i=0; i<1; i++){	
            for(j=0; j< Math.min(10,m_br); j++){

                System.out.print(phc[j]);
                System.out.print(" ");
            }
        }

        System.out.println("");

    }

    public static void OnMultLine(int m_ar, int m_br){
         //creating 3 matrices    
        double[] pha =new double[m_ar*m_br]; 
        double[] phb =new double[m_ar*m_br]; 
        double[] phc =new double[m_ar*m_br];   
        double temp; 
	    int i, j, k;
            
        //filling matrix A
        for(i=0; i<m_ar; i++)
            for(j=0; j<m_ar; j++)
                pha[i*m_ar + j] = (double)1.0;

        //filling matrix B
        for(i=0; i<m_br; i++)
            for(j=0; j<m_br; j++)
                phb[i*m_br + j] = (double)(i+1);


        double Time1, Time2;

        Time1 = System.nanoTime();
        //Product Calculation
        for(i=0; i<m_ar; i++)
        {	for( k=0; k<m_ar; k++)
            {	
                for( j=0; j<m_br; j++)
                {	
                    phc[i*m_ar+j] += pha[i*m_ar+k] * phb[k*m_br+j];
                }
            }
        }

        Time2 = System.nanoTime();

        double TimeElapsed = (Time2-Time1)/(Math.pow(10,9));

        System.out.println("Time: " + TimeElapsed + " seconds");

        //Output Result Matrix
        for(i=0; i<1; i++){	
            for(j=0; j< Math.min(10,m_br); j++){

                System.out.print(phc[j]);
                System.out.print(" ");
            }
        }

        System.out.println("");
    }
}  
