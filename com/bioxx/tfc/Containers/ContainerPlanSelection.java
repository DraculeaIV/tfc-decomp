/*    */ package com.bioxx.tfc.Containers;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerPlanSelection
/*    */   extends ContainerTFC
/*    */ {
/*    */   private TEAnvil anvil;
/* 13 */   private String plan = "";
/*    */   
/*    */   public ContainerPlanSelection(EntityPlayer p, TEAnvil a, World w, int x, int y, int z) {
/* 16 */     this.anvil = a;
/*    */     
/* 18 */     this.player = p;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75142_b() {
/* 24 */     super.func_75142_b();
/* 25 */     if (this.anvil.craftingPlan != this.plan)
/* 26 */       this.plan = this.anvil.craftingPlan; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Containers\ContainerPlanSelection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */