/*     */ package com.bioxx.tfc.Render;
/*     */ 
/*     */ import com.bioxx.tfc.Entities.EntityStand;
/*     */ import com.bioxx.tfc.Render.Models.ModelStand;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderBiped;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.ForgeHooksClient;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderEntityStand
/*     */   extends RenderBiped
/*     */ {
/*     */   private ModelBiped modelArmorChestplate;
/*     */   private ModelBiped modelArmor;
/*  33 */   private static final ResourceLocation TEXTURE = new ResourceLocation("terrafirmacraft", "textures/mob/stand.png");
/*     */   
/*     */   private ModelRenderer plume;
/*     */   
/*     */   private ModelRenderer plume2;
/*     */   private ModelRenderer hornR1;
/*     */   private ModelRenderer hornL1;
/*     */   private ModelRenderer hornR2;
/*     */   private ModelRenderer hornL2;
/*  42 */   private RenderLargeItem standBlockRenderer = new RenderLargeItem();
/*     */ 
/*     */   
/*     */   public RenderEntityStand() {
/*  46 */     super((ModelBiped)new ModelStand(), 0.5F);
/*  47 */     this.field_77071_a = (ModelBiped)this.field_77045_g;
/*  48 */     this.modelArmorChestplate = (ModelBiped)new ModelStand(1.0F);
/*  49 */     this.modelArmor = (ModelBiped)new ModelStand(0.5F);
/*     */     
/*  51 */     this.plume = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  52 */     this.plume2 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  53 */     this.plume.func_78790_a(-1.0F, -6.0F, -10.0F, 2, 6, 10, 0.5F);
/*  54 */     this.plume2.func_78789_a(-1.0F, -6.0F, -10.0F, 2, 6, 10);
/*  55 */     this.plume.func_78793_a(0.0F, -8.0F, 2.0F);
/*  56 */     this.plume2.func_78793_a(0.0F, -2.0F, 4.0F);
/*  57 */     this.plume2.field_78795_f = -1.0471976F;
/*     */     
/*  59 */     this.hornR1 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  60 */     this.hornR1.func_78789_a(-6.0F, -1.5F, -1.5F, 3, 3, 6);
/*  61 */     this.hornL1 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 0);
/*  62 */     this.hornL1.func_78789_a(6.0F, -1.5F, -1.5F, 3, 3, 6);
/*  63 */     this.hornR1.func_78793_a(-6.0F, -6.0F, 5.0F);
/*  64 */     this.hornL1.func_78793_a(6.0F, -6.0F, 8.0F);
/*  65 */     this.hornR1.field_78796_g = -1.5707964F;
/*  66 */     this.hornR1.field_78795_f = -0.2617994F;
/*  67 */     this.hornL1.field_78796_g = 1.5707964F;
/*  68 */     this.hornL1.field_78795_f = -0.2617994F;
/*  69 */     this.hornR2 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 9);
/*  70 */     this.hornR2.func_78789_a(0.0F, 0.0F, -5.0F, 2, 2, 5);
/*  71 */     this.hornR2.func_78793_a(-6.0F, 0.0F, 2.0F);
/*  72 */     this.hornR2.field_78795_f = 1.5707964F;
/*  73 */     this.hornR2.field_78808_h = 0.5235988F;
/*  74 */     this.hornL2 = new ModelRenderer((ModelBase)this.modelArmorChestplate, 40, 9);
/*  75 */     this.hornL2.func_78789_a(0.0F, 0.0F, -5.0F, 2, 2, 5);
/*  76 */     this.hornL2.func_78793_a(7.0F, 0.0F, 2.0F);
/*  77 */     this.hornL2.field_78795_f = 1.5707964F;
/*  78 */     this.hornL2.field_78808_h = -0.5235988F;
/*     */     
/*  80 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.plume);
/*  81 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.plume2);
/*  82 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.hornR1);
/*  83 */     this.modelArmorChestplate.field_78116_c.func_78792_a(this.hornL1);
/*  84 */     this.hornR1.func_78792_a(this.hornR2);
/*  85 */     this.hornL1.func_78792_a(this.hornL2);
/*  86 */     this.hornR1.field_78806_j = false;
/*  87 */     this.hornL1.field_78806_j = false;
/*  88 */     this.plume.field_78806_j = false;
/*  89 */     this.plume2.field_78806_j = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int func_77032_a(EntityLivingBase entity, int pass, float delta) {
/*  95 */     return setArmorModelTFC((EntityStand)entity, pass, delta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityLiving entity) {
/* 101 */     return TEXTURE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(Entity e, double par2, double par3, double par4, float par5, float par6) {
/* 106 */     float rotation = (e instanceof EntityStand) ? ((EntityStand)e).getRotation() : 0.0F;
/* 107 */     GL11.glPushMatrix();
/*     */     
/* 109 */     super.func_76986_a(e, par2, par3, par4, rotation, 0.0F);
/* 110 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77043_a(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
/* 116 */     super.func_77043_a(par1EntityLivingBase, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77041_b(EntityLivingBase entity, float par2) {
/* 122 */     GL11.glScalef(1.0F, 0.95F, 1.0F);
/*     */     
/* 124 */     int l = 0;
/* 125 */     if (entity instanceof EntityStand) {
/* 126 */       l = ((EntityStand)entity).woodType;
/*     */     }
/* 128 */     this.standBlockRenderer.render(entity, new ItemStack(TFCBlocks.armorStand, 1, l));
/*     */   }
/*     */ 
/*     */   
/*     */   protected int setArmorModelTFC(EntityStand stand, int par2, float par3) {
/* 133 */     ItemStack itemstack = stand.getArmorInSlot(3 - par2);
/*     */     
/* 135 */     if (itemstack != null) {
/*     */       
/* 137 */       Item item = itemstack.func_77973_b();
/*     */       
/* 139 */       if (item instanceof ItemArmor) {
/*     */         
/* 141 */         ItemArmor itemarmor = (ItemArmor)item;
/* 142 */         func_110776_a(RenderBiped.getArmorResource((Entity)stand, itemstack, par2, null));
/* 143 */         ModelBiped modelbiped = (par2 == 2) ? this.modelArmor : this.modelArmorChestplate;
/* 144 */         modelbiped.field_78116_c.field_78806_j = (par2 == 0);
/* 145 */         modelbiped.field_78114_d.field_78806_j = (par2 == 0);
/* 146 */         modelbiped.field_78115_e.field_78806_j = (par2 == 1 || par2 == 2);
/* 147 */         modelbiped.field_78112_f.field_78806_j = (par2 == 1);
/* 148 */         modelbiped.field_78113_g.field_78806_j = (par2 == 1);
/* 149 */         modelbiped.field_78123_h.field_78806_j = (par2 == 2 || par2 == 3);
/* 150 */         modelbiped.field_78124_i.field_78806_j = (par2 == 2 || par2 == 3);
/* 151 */         modelbiped = ForgeHooksClient.getArmorModel((EntityLivingBase)stand, itemstack, par2, modelbiped);
/* 152 */         func_77042_a((ModelBase)modelbiped);
/* 153 */         modelbiped.field_78095_p = this.field_77045_g.field_78095_p;
/* 154 */         modelbiped.field_78093_q = this.field_77045_g.field_78093_q;
/* 155 */         modelbiped.field_78091_s = this.field_77045_g.field_78091_s;
/* 156 */         float f1 = 1.0F;
/*     */ 
/*     */         
/* 159 */         int j = itemarmor.func_82814_b(itemstack);
/* 160 */         if (j != -1) {
/*     */           
/* 162 */           float f2 = (j >> 16 & 0xFF) / 255.0F;
/* 163 */           float f3 = (j >> 8 & 0xFF) / 255.0F;
/* 164 */           float f4 = (j & 0xFF) / 255.0F;
/* 165 */           GL11.glColor3f(f1 * f2, f1 * f3, f1 * f4);
/*     */           
/* 167 */           if (itemstack.func_77948_v())
/*     */           {
/* 169 */             return 31;
/*     */           }
/*     */           
/* 172 */           return 16;
/*     */         } 
/*     */         
/* 175 */         GL11.glColor3f(f1, f1, f1);
/*     */         
/* 177 */         if (itemstack.func_77948_v())
/*     */         {
/* 179 */           return 15;
/*     */         }
/*     */         
/* 182 */         return 1;
/*     */       } 
/*     */     } 
/*     */     
/* 186 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\RenderEntityStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */