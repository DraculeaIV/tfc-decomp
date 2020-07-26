/*    */ package com.bioxx.tfc.Entities.Mobs;
/*    */ 
/*    */ import com.bioxx.tfc.Core.WeatherManager;
/*    */ import com.bioxx.tfc.api.Enums.EnumDamageType;
/*    */ import com.bioxx.tfc.api.Interfaces.ICausesDamage;
/*    */ import com.bioxx.tfc.api.Interfaces.IInnateArmor;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.monster.EntityEnderman;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityEndermanTFC
/*    */   extends EntityEnderman
/*    */   implements ICausesDamage, IInnateArmor
/*    */ {
/* 16 */   public static boolean[] carriableBlocks = new boolean[256];
/*    */ 
/*    */   
/*    */   public EntityEndermanTFC(World par1World) {
/* 20 */     super(par1World);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 26 */     super.func_110147_ax();
/* 27 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(100.0D);
/* 28 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumDamageType getDamageType() {
/* 34 */     return EnumDamageType.GENERIC;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCrushArmor() {
/* 39 */     return -335;
/*    */   }
/*    */   
/*    */   public int getSlashArmor() {
/* 43 */     return -335;
/*    */   }
/*    */   
/*    */   public int getPierceArmor() {
/* 47 */     return -335;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70026_G() {
/* 56 */     return (this.field_70171_ac || WeatherManager.isRainingOnCoord(this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v) || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) || this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u + this.field_70131_O), MathHelper.func_76128_c(this.field_70161_v)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Entities\Mobs\EntityEndermanTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */