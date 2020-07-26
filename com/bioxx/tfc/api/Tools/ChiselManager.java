/*    */ package com.bioxx.tfc.api.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChiselManager
/*    */ {
/* 18 */   private static final ChiselManager INSTANCE = new ChiselManager(); public static final ChiselManager getInstance() {
/* 19 */     return INSTANCE;
/*    */   }
/*    */   
/*    */   private List<ChiselMode> chiselModes;
/*    */   
/*    */   private ChiselManager() {
/* 25 */     this.chiselModes = new ArrayList<ChiselMode>();
/*    */   }
/*    */ 
/*    */   
/*    */   public void addChiselMode(ChiselMode mode) {
/* 30 */     this.chiselModes.add(mode);
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getResourceLocation(int mode) {
/* 35 */     return ((ChiselMode)this.chiselModes.get(mode)).getResourceLocation();
/*    */   }
/*    */   
/*    */   public int getTextureU(int mode) {
/* 39 */     return ((ChiselMode)this.chiselModes.get(mode)).getTextureU();
/*    */   }
/*    */   
/*    */   public int getTextureV(int mode) {
/* 43 */     return ((ChiselMode)this.chiselModes.get(mode)).getTextureV();
/*    */   }
/*    */   public int getDivX(int mode, Block block) {
/* 46 */     return ((ChiselMode)this.chiselModes.get(mode)).getDivX(block);
/*    */   } public int getDivY(int mode, Block block) {
/* 48 */     return ((ChiselMode)this.chiselModes.get(mode)).getDivY(block);
/*    */   } public int getDivZ(int mode, Block block) {
/* 50 */     return ((ChiselMode)this.chiselModes.get(mode)).getDivZ(block);
/*    */   } public int getSize() {
/* 52 */     return this.chiselModes.size();
/*    */   } public void setDivision(int mode, int sideHit) {
/* 54 */     ((ChiselMode)this.chiselModes.get(mode)).setDivision(sideHit);
/*    */   }
/*    */   public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ) {
/* 57 */     int mode = -1;
/* 58 */     PlayerInfo pi = null;
/* 59 */     pi = ChiselMode.playerInfo(world, player);
/* 60 */     if (pi != null) mode = pi.chiselMode; 
/* 61 */     return ((ChiselMode)this.chiselModes.get(mode)).onUsedHandler(world, player, x, y, z, id, meta, side, hitX, hitY, hitZ);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Tools\ChiselManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */