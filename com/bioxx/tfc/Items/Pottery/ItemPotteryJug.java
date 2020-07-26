/*     */ package com.bioxx.tfc.Items.Pottery;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.FoodStatsTFC;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Time;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemPotteryJug
/*     */   extends ItemPotteryBase
/*     */ {
/*     */   private IIcon waterIcon;
/*     */   
/*     */   public ItemPotteryJug() {
/*  31 */     this.metaNames = new String[] { "Clay Jug", "Ceramic Jug", "Water Jug" };
/*  32 */     this.stackable = false;
/*     */     
/*  34 */     setWeight(EnumWeight.LIGHT);
/*  35 */     setSize(EnumSize.SMALL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack is, World world, EntityPlayer player) {
/*  41 */     if (!world.field_72995_K) {
/*     */       
/*  43 */       if (is.func_77960_j() == 2)
/*     */       {
/*  45 */         TFC_Core.getPlayerFoodStats(player).restoreWater(player, 24000);
/*     */       }
/*     */       
/*  48 */       if (is.func_77960_j() > 1 && !player.field_71075_bZ.field_75098_d)
/*     */       {
/*  50 */         if (world.field_73012_v.nextInt(50) == 0) {
/*     */           
/*  52 */           world.func_72956_a((Entity)player, "terrafirmacraft:item.ceramicbreak", 0.7F, player.field_70170_p.field_73012_v.nextFloat() * 0.2F + 0.8F);
/*  53 */           is.field_77994_a--;
/*     */         }
/*     */         else {
/*     */           
/*  57 */           is.func_77964_b(1);
/*     */         } 
/*     */       }
/*     */     } 
/*  61 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack is) {
/*  70 */     return 32;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack is) {
/*  79 */     return EnumAction.drink;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer entity) {
/*  88 */     MovingObjectPosition mop = func_77621_a(world, entity, true);
/*  89 */     FoodStatsTFC fs = TFC_Core.getPlayerFoodStats(entity);
/*  90 */     Boolean canDrink = Boolean.valueOf(((fs.getMaxWater(entity) - 500) > fs.waterLevel));
/*     */     
/*  92 */     boolean playNote = false;
/*  93 */     float lookAngle = 0.0F;
/*  94 */     if (mop == null) {
/*     */       
/*  96 */       if (is.func_77960_j() > 1 && canDrink.booleanValue()) {
/*     */         
/*  98 */         entity.func_71008_a(is, func_77626_a(is));
/*     */       }
/* 100 */       else if (is.func_77960_j() == 1) {
/* 101 */         Vec3 lookVec = entity.func_70040_Z();
/* 102 */         lookAngle = (float)(lookVec.field_72448_b / 2.0D);
/* 103 */         if (!is.func_77942_o()) {
/* 104 */           playNote = true;
/* 105 */           is.field_77990_d = new NBTTagCompound();
/* 106 */           is.field_77990_d.func_74772_a("blowTime", TFC_Time.getTotalTicks());
/*     */         }
/* 108 */         else if (is.field_77990_d.func_74764_b("blowTime") && is.field_77990_d
/* 109 */           .func_74763_f("blowTime") + 10L < TFC_Time.getTotalTicks()) {
/*     */           
/* 111 */           playNote = true;
/* 112 */           is.field_77990_d.func_74772_a("blowTime", TFC_Time.getTotalTicks());
/*     */         }
/* 114 */         else if (!is.field_77990_d.func_74764_b("blowTime")) {
/* 115 */           playNote = true;
/* 116 */           is.field_77990_d.func_74772_a("blowTime", TFC_Time.getTotalTicks());
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 122 */     else if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 124 */       int x = mop.field_72311_b;
/* 125 */       int y = mop.field_72312_c;
/* 126 */       int z = mop.field_72309_d;
/*     */ 
/*     */       
/* 129 */       int flowX = x;
/* 130 */       int flowY = y;
/* 131 */       int flowZ = z;
/* 132 */       switch (mop.field_72310_e) {
/*     */         
/*     */         case 0:
/* 135 */           flowY = y - 1;
/*     */           break;
/*     */         case 1:
/* 138 */           flowY = y + 1;
/*     */           break;
/*     */         case 2:
/* 141 */           flowZ = z - 1;
/*     */           break;
/*     */         case 3:
/* 144 */           flowZ = z + 1;
/*     */           break;
/*     */         case 4:
/* 147 */           flowX = x - 1;
/*     */           break;
/*     */         case 5:
/* 150 */           flowX = x + 1;
/*     */           break;
/*     */       } 
/*     */       
/* 154 */       if ((!entity.func_70093_af() && !world.field_72995_K && 
/* 155 */         TFC_Core.isFreshWater(world.func_147439_a(x, y, z))) || TFC_Core.isFreshWater(world.func_147439_a(flowX, flowY, flowZ))) {
/*     */         
/* 157 */         if (is.func_77960_j() == 1)
/*     */         {
/* 159 */           is.func_77964_b(2);
/* 160 */           playNote = false;
/*     */ 
/*     */         
/*     */         }
/* 164 */         else if (canDrink.booleanValue())
/*     */         {
/* 166 */           entity.func_71008_a(is, func_77626_a(is));
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 172 */       else if (is.func_77960_j() == 2 && canDrink.booleanValue()) {
/*     */         
/* 174 */         entity.func_71008_a(is, func_77626_a(is));
/*     */       }
/* 176 */       else if (is.func_77960_j() == 1) {
/* 177 */         Vec3 lookVec = entity.func_70040_Z();
/* 178 */         lookAngle = (float)(lookVec.field_72448_b / 2.0D);
/* 179 */         if (!is.func_77942_o()) {
/* 180 */           is.field_77990_d = new NBTTagCompound();
/* 181 */           is.field_77990_d.func_74772_a("blowTime", TFC_Time.getTotalTicks());
/*     */         }
/* 183 */         else if (is.field_77990_d.func_74764_b("blowTime") && is.field_77990_d
/* 184 */           .func_74763_f("blowTime") + 10L < TFC_Time.getTotalTicks()) {
/*     */           
/* 186 */           is.field_77990_d.func_74772_a("blowTime", TFC_Time.getTotalTicks());
/*     */         }
/* 188 */         else if (!is.field_77990_d.func_74764_b("blowTime")) {
/* 189 */           playNote = true;
/* 190 */           is.field_77990_d.func_74772_a("blowTime", TFC_Time.getTotalTicks());
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 195 */       if (!world.func_72962_a(entity, x, y, z))
/*     */       {
/* 197 */         return is;
/*     */       }
/*     */       
/* 200 */       if (!entity.func_82247_a(x, y, z, mop.field_72310_e, is))
/*     */       {
/* 202 */         return is;
/*     */       }
/*     */     } 
/*     */     
/* 206 */     if (playNote) {
/* 207 */       entity.func_85030_a("terrafirmacraft:item.jug.blow", 1.0F, 1.0F + lookAngle);
/*     */     }
/* 209 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_77617_a(int damage) {
/* 215 */     if (damage == 0)
/* 216 */       return this.clayIcon; 
/* 217 */     if (damage == 1)
/* 218 */       return this.ceramicIcon; 
/* 219 */     if (damage == 2) {
/* 220 */       return this.waterIcon;
/*     */     }
/*     */     
/* 223 */     return this.waterIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/* 229 */     super.func_94581_a(registerer);
/* 230 */     this.waterIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + "Water Jug");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 236 */     super.func_77624_a(is, player, arraylist, flag);
/* 237 */     if (is.func_77942_o() && is.field_77990_d.func_74764_b("LiquidType"))
/*     */     {
/* 239 */       arraylist.add(is.field_77990_d.func_74779_i("LiquidType"));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Pottery\ItemPotteryJug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */