class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 計算兩個矩形的面積
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        
        // 計算重疊區域的寬度和高度
        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        
        // 計算重疊區域的面積
        int overlapArea = overlapWidth * overlapHeight;
        
        // 總面積是兩個矩形的面積之和減去重疊部分的面積
        return areaA + areaB - overlapArea;
    }
}