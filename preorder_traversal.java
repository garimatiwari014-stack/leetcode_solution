import java.util.ArrayList;
import java.util.*;

public class preorder_traversal{
    public List<Integer> preOrderTraversal(TreeNode root){

        List<Integer> res= new ArrayList<>();
        dfs(root , res );
        return res;
    }
    void dfs(TreeNode node , List<Integer> res){
        if(node == null){return;

        }
        res.add(node.val);
        dfs(node.left , res);
        dfs(node.right , res);

    }

    
}