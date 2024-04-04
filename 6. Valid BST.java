import java.util.HashMap;
class Main {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        void solver(Node root)
        {
            if(root==null)return;
            solver(root.left);
            arr.add(root.data);
            solver(root.right);
        }
        boolean valid(Node root)
        {
            solver(root);
            int temp = -1e9;
            for(Integer i : arr)
                if(temp > i )return false;
                else
                 temp = i;
            return true;
        }
    }
}