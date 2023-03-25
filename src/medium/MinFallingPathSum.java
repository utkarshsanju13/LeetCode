package medium;

public class MinFallingPathSum {

	public static void main(String[] args) {
		
		int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		System.out.println(minFallingPathSum(matrix));
		System.out.println(minFallingPathSumII(matrix));
		
	}

	private static int minFallingPathSum(int[][] matrix) {
		 int n = matrix.length;
	        int minSum = Integer.MAX_VALUE;
	        
	        if(n == 1){
	            return matrix[0][0];
	        }
	        
	        for(int i = n-2; i >=0 ; i--){
	            
	            for(int j = 0; j < n; j++){
	                
	                if(j == 0){
	                    int min = Math.min(matrix[i+1][j], matrix[i+1][j+1]);
	                    matrix[i][j]+=min;
	                }else if(j == n-1){
	                    int min = Math.min(matrix[i+1][j], matrix[i+1][j-1]);
	                    matrix[i][j] +=min;
	                }else{
	                    int min = Math.min(matrix[i+1][j], Math.min(matrix[i+1][j+1], matrix[i+1][j-1]));
	                    matrix[i][j] +=min;
	                }
	            }
	        }
	        
	        
	        for(int i = 0; i <n; i++){
	        	System.out.println();
	            minSum = Math.min(minSum, matrix[0][i]);
	        }  
	        return minSum;
}
	
	 public static int minFallingPathSumII(int[][] grid) {
	        int minSum = Integer.MAX_VALUE;
	        int n = grid.length;
	        
	        for(int i = n-2; i >= 0; i--){
	            
	            for(int j = 0; j < n; j++){
	                int min = Integer.MAX_VALUE;
	                for(int k = 0; k < n; k++){
	                    if(k!=j){
	                        min = Math.min(min, grid[i+1][k]);   
	                    }
	                }
	                
	                grid[i][j]+=min;
	            }
	        }
	        
	        for(int j = 0; j < n;j++){
	            
	            minSum = Math.min(minSum, grid[0][j]);
	        }
	        
	        return minSum;
	    }
}
