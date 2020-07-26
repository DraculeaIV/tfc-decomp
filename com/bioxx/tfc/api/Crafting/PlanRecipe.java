/*    */ package com.bioxx.tfc.api.Crafting;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.RuleEnum;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlanRecipe
/*    */ {
/*    */   public RuleEnum[] rules;
/*    */   public IIcon icon;
/*    */   
/*    */   public PlanRecipe(RuleEnum[] r, IIcon i) {
/* 14 */     this.rules = (RuleEnum[])r.clone();
/* 15 */     this.icon = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public PlanRecipe(RuleEnum[] r) {
/* 20 */     this.rules = (RuleEnum[])r.clone();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Crafting\PlanRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */