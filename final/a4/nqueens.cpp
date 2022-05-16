#include<iostream>
#include<vector>
#include<string>

using namespace std;

class SolutionMixed {

public:
    
    void solve(int col,vector<string> &board, vector<vector<string > > &ans, vector<int> &leftRow, vector<int> &upperDiagonal, vector<int> &lowerDiagonal,int n){
        
        if(col ==n){
            ans.push_back(board);
            return;
        }
        
        for(int row =0;row<n;row++){
            if(leftRow[row]==0 && upperDiagonal[row+col]==0 && lowerDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                upperDiagonal[row+col]=1;
                lowerDiagonal[n-1+col-row]=1;
                solve(col+1,board,ans,leftRow,upperDiagonal,lowerDiagonal,n);
                board[row][col]='.';
                leftRow[row]=0;
                upperDiagonal[row+col]=0;
                lowerDiagonal[n-1+col-row]=0;
            }
        }
        
        
    }
    
    
    vector<vector<string > > solveNQueens(int n) {
        vector<vector<string > > ans;
        vector<string> board(n);
        string s(n,'.');
        for(int i=0;i<n;i++){
            board[i]=s;
        }
        vector<int> leftRow(n,0) , upperDiagonal(2*n - 1,0), lowerDiagonal(2*n - 1, 0);
        solve(0,board,ans,leftRow,upperDiagonal,lowerDiagonal,n);
        return ans;
    }
};


class Solution{
    public:

    bool isSafe(int row,int col,vector< string> board){

        for(int i=0;i<col;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row,j=col;i<board.size() && j>=0;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }



    void solve(int col, vector< string> &board,vector< vector <string > > &ans, int n){

        if(col == n){
            ans.push_back(board);
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                
                solve(col+1,board,ans,n);

                board[row][col]='*';
            }
        }

    }

    vector<vector< string > > solveNQueens(int n){

        vector<vector< string > > ans ;
        vector< string > board(n);
        string s(n,'*');
        for(int i=0;i<n;i++){
            board[i]=s;
        }
        solve(0,board,ans,n);
        return ans;


    }
};

int main(){

    SolutionMixed s;
    vector<vector<string > > ans = s.solveNQueens(4);
    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<endl;
        }
        cout<<endl;
    }

    return 0;
}