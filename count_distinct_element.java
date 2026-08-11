class DistinctWindow {
public static void main(String[] args){
int[] a = {1,2,1,3,4,2,3};
int k = 4;
for(int i=0;i<=a.length-k;i++){
HashSet<Integer> set = new HashSet<>();
for(int j=i;j<i+k;j++) set.add(a[j]);
System.out.print(set.size() + " ");
}
}
}