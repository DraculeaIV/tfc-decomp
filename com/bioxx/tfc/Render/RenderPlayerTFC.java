/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import com.bioxx.tfc.Entities.EntityStand;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderBiped;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.client.ForgeHooksClient;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderPlayerTFC
/*     */   extends RenderPlayer
/*     */ {
/*     */   private ModelBiped modelArmorChestplate;
/*     */   private ModelBiped modelArmor;
/*  33 */   public static String[] armorFilenamePrefix = new String[] { "cloth", "chain", "iron", "diamond", "gold" };
/*     */   
/*     */   public static final float NAME_TAG_RANGE = 64.0F;
/*     */   
/*     */   public static final float NAME_TAG_RANGE_SNEAK = 32.0F;
/*     */   
/*     */   private ModelRenderer plume;
/*     */   private ModelRenderer plume2;
/*     */   private ModelRenderer hornR1;
/*     */   private ModelRenderer hornL1;
/*     */   private ModelRenderer hornR2;
/*     */   private ModelRenderer hornL2;
/*     */   
/*     */   public RenderPlayerTFC() {
/*  47 */     this.field_77109_a = (ModelBiped)this.field_77045_g;
/*  48 */     this.modelArmorChestplate = new ModelBiped(1.0F);
/*  49 */     this.modelArmor = new ModelBiped(0.5F);
/*     */ 
/*     */     
/*  52 */     this.plume = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  53 */     this.plume2 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  54 */     this.plume.func_78790_a(-1.0F, -6.0F, -10.0F, 2, 6, 10, 0.5F);
/*  55 */     this.plume2.func_78789_a(-1.0F, -6.0F, -10.0F, 2, 6, 10);
/*  56 */     this.plume.func_78793_a(0.0F, -8.0F, 2.0F);
/*  57 */     this.plume2.func_78793_a(0.0F, -2.0F, 4.0F);
/*  58 */     this.plume2.field_78795_f = -1.0471976F;
/*     */     
/*  60 */     this.hornR1 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  61 */     this.hornR1.func_78789_a(-6.0F, -1.5F, -1.5F, 3, 3, 6);
/*  62 */     this.hornL1 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  63 */     this.hornL1.func_78789_a(6.0F, -1.5F, -1.5F, 3, 3, 6);
/*  64 */     this.hornR1.func_78793_a(-6.0F, -6.0F, 5.0F);
/*  65 */     this.hornL1.func_78793_a(6.0F, -6.0F, 8.0F);
/*  66 */     this.hornR1.field_78796_g = -1.5707964F;
/*  67 */     this.hornR1.field_78795_f = -0.2617994F;
/*  68 */     this.hornL1.field_78796_g = 1.5707964F;
/*  69 */     this.hornL1.field_78795_f = -0.2617994F;
/*  70 */     this.hornR2 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 9);
/*  71 */     this.hornR2.func_78789_a(0.0F, 0.0F, -5.0F, 2, 2, 5);
/*  72 */     this.hornR2.func_78793_a(-6.0F, 0.0F, 2.0F);
/*  73 */     this.hornR2.field_78795_f = 1.5707964F;
/*  74 */     this.hornR2.field_78808_h = 0.5235988F;
/*  75 */     this.hornL2 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 9);
/*  76 */     this.hornL2.func_78789_a(0.0F, 0.0F, -5.0F, 2, 2, 5);
/*  77 */     this.hornL2.func_78793_a(7.0F, 0.0F, 2.0F);
/*  78 */     this.hornL2.field_78795_f = 1.5707964F;
/*  79 */     this.hornL2.field_78808_h = -0.5235988F;
/*     */     
/*  81 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.plume);
/*  82 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.plume2);
/*  83 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.hornR1);
/*  84 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.hornL1);
/*  85 */     this.hornR1.func_78792_a(this.hornR2);
/*  86 */     this.hornL1.func_78792_a(this.hornL2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_77032_a(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
/*  92 */     if (par1EntityLivingBase instanceof EntityStand)
/*     */     {
/*  94 */       return setArmorModelTFC((EntityStand)par1EntityLivingBase, par2, par3);
/*     */     }
/*  96 */     return func_77032_a((AbstractClientPlayer)par1EntityLivingBase, par2, par3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int setArmorModelTFC(EntityStand stand, int par2, float par3) {
/* 101 */     ItemStack itemstack = stand.func_71124_b(3 - par2);
/*     */     
/* 103 */     if (itemstack != null) {
/*     */       
/* 105 */       Item item = itemstack.func_77973_b();
/*     */       
/* 107 */       if (item instanceof ItemArmor) {
/*     */         
/* 109 */         ItemArmor itemarmor = (ItemArmor)item;
/* 110 */         func_110776_a(RenderBiped.getArmorResource((Entity)stand, itemstack, par2, null));
/* 111 */         ModelBiped modelbiped = (par2 == 2) ? this.modelArmor : this.modelArmorChestplate;
/* 112 */         modelbiped.field_78116_c.field_78806_j = (par2 == 0);
/* 113 */         modelbiped.field_78114_d.field_78806_j = (par2 == 0);
/* 114 */         modelbiped.field_78115_e.field_78806_j = (par2 == 1 || par2 == 2);
/* 115 */         modelbiped.field_78112_f.field_78806_j = (par2 == 1);
/* 116 */         modelbiped.field_78113_g.field_78806_j = (par2 == 1);
/* 117 */         modelbiped.field_78123_h.field_78806_j = (par2 == 2 || par2 == 3);
/* 118 */         modelbiped.field_78124_i.field_78806_j = (par2 == 2 || par2 == 3);
/* 119 */         modelbiped = ForgeHooksClient.getArmorModel((EntityLivingBase)stand, itemstack, par2, modelbiped);
/* 120 */         func_77042_a((ModelBase)modelbiped);
/* 121 */         modelbiped.field_78095_p = this.field_77045_g.field_78095_p;
/* 122 */         modelbiped.field_78093_q = this.field_77045_g.field_78093_q;
/* 123 */         modelbiped.field_78091_s = this.field_77045_g.field_78091_s;
/* 124 */         float f1 = 1.0F;
/*     */ 
/*     */         
/* 127 */         int j = itemarmor.func_82814_b(itemstack);
/* 128 */         if (j != -1) {
/*     */           
/* 130 */           float f2 = (j >> 16 & 0xFF) / 255.0F;
/* 131 */           float f3 = (j >> 8 & 0xFF) / 255.0F;
/* 132 */           float f4 = (j & 0xFF) / 255.0F;
/* 133 */           GL11.glColor3f(f1 * f2, f1 * f3, f1 * f4);
/*     */           
/* 135 */           if (itemstack.func_77948_v())
/*     */           {
/* 137 */             return 31;
/*     */           }
/*     */           
/* 140 */           return 16;
/*     */         } 
/*     */         
/* 143 */         GL11.glColor3f(f1, f1, f1);
/*     */         
/* 145 */         if (itemstack.func_77948_v())
/*     */         {
/* 147 */           return 15;
/*     */         }
/*     */         
/* 150 */         return 1;
/*     */       } 
/*     */     } 
/* 153 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_77032_a(AbstractClientPlayer par1AbstractClientPlayer, int slotIndex, float partialTick) {
/* 188 */     ItemStack itemstack = par1AbstractClientPlayer.field_71071_by.func_70440_f(3 - slotIndex);
/*     */     
/* 190 */     this.plume.field_78806_j = false;
/* 191 */     this.plume2.field_78806_j = false;
/* 192 */     this.hornR1.field_78806_j = false;
/* 193 */     this.hornL1.field_78806_j = false;
/* 194 */     if (itemstack != null) {
/*     */       
/* 196 */       Item item = itemstack.func_77973_b();
/*     */       
/* 198 */       if (item instanceof ItemArmor) {
/*     */         
/* 200 */         ItemArmor itemarmor = (ItemArmor)item;
/* 201 */         func_110776_a(RenderBiped.getArmorResource((Entity)par1AbstractClientPlayer, itemstack, slotIndex, null));
/* 202 */         ModelBiped modelbiped = (slotIndex == 2) ? this.modelArmor : this.modelArmorChestplate;
/* 203 */         modelbiped.field_78116_c.field_78806_j = (slotIndex == 0);
/* 204 */         this.plume.field_78806_j = false;
/* 205 */         this.plume2.field_78806_j = false;
/* 206 */         this.hornR1.field_78806_j = false;
/* 207 */         this.hornL1.field_78806_j = false;
/* 208 */         modelbiped.field_78114_d
/* 209 */           .field_78806_j = (slotIndex == 0 && itemstack.func_77973_b() != TFCItems.bronzeHelmet && itemstack.func_77973_b() != TFCItems.wroughtIronHelmet);
/* 210 */         modelbiped.field_78115_e.field_78806_j = (slotIndex == 1 || slotIndex == 2);
/* 211 */         modelbiped.field_78112_f.field_78806_j = (slotIndex == 1);
/* 212 */         modelbiped.field_78113_g.field_78806_j = (slotIndex == 1);
/* 213 */         modelbiped.field_78123_h.field_78806_j = (slotIndex == 2 || slotIndex == 3);
/* 214 */         modelbiped.field_78124_i.field_78806_j = (slotIndex == 2 || slotIndex == 3);
/* 215 */         func_77042_a((ModelBase)modelbiped);
/*     */         
/* 217 */         modelbiped.field_78095_p = this.field_77045_g.field_78095_p;
/* 218 */         modelbiped.field_78093_q = this.field_77045_g.field_78093_q;
/* 219 */         modelbiped.field_78091_s = this.field_77045_g.field_78091_s;
/*     */         
/* 221 */         float f1 = 1.0F;
/*     */         
/* 223 */         if (itemarmor.func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
/*     */           
/* 225 */           int j = itemarmor.func_82814_b(itemstack);
/* 226 */           float f2 = (j >> 16 & 0xFF) / 255.0F;
/* 227 */           float f3 = (j >> 8 & 0xFF) / 255.0F;
/* 228 */           float f4 = (j & 0xFF) / 255.0F;
/* 229 */           GL11.glColor3f(f1 * f2, f1 * f3, f1 * f4);
/*     */           
/* 231 */           if (itemstack.func_77948_v())
/*     */           {
/* 233 */             return 31;
/*     */           }
/*     */           
/* 236 */           return 16;
/*     */         } 
/*     */         
/* 239 */         GL11.glColor3f(f1, f1, f1);
/*     */         
/* 241 */         if (itemstack.func_77948_v())
/*     */         {
/* 243 */           return 15;
/*     */         }
/*     */         
/* 246 */         return 1;
/*     */       } 
/*     */     } 
/* 249 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderPlayerTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */