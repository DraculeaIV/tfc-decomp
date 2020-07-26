/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockColored;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.BonemealEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemDyeCustom
/*     */   extends ItemTerra
/*     */ {
/*  30 */   public static final String[] DYE_COLOR_NAMES = new String[] { "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white" };
/*  31 */   public static final int[] DYE_COLORS = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] icons;
/*     */ 
/*     */   
/*     */   public ItemDyeCustom() {
/*  38 */     func_77627_a(true);
/*  39 */     func_77656_e(0);
/*  40 */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int par1) {
/*  51 */     int j = MathHelper.func_76125_a(par1, 0, 15);
/*  52 */     return this.icons[j];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack par1ItemStack) {
/*  62 */     int i = MathHelper.func_76125_a(par1ItemStack.func_77960_j(), 0, 15);
/*  63 */     return func_77658_a() + "." + DYE_COLOR_NAMES[i];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/*  70 */     this.icons = new IIcon[DYE_COLOR_NAMES.length];
/*     */     
/*  72 */     for (int i = 0; i < DYE_COLOR_NAMES.length; i++)
/*     */     {
/*  74 */       this.icons[i] = par1IconRegister.func_94245_a(func_111208_A() + "_" + DYE_COLOR_NAMES[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  81 */     if (!par2EntityPlayer.func_82247_a(par4, par5, par6, par7, par1ItemStack))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (par1ItemStack.func_77960_j() == 15) {
/*     */       
/*  93 */       Block var11 = par3World.func_147439_a(par4, par5, par6);
/*     */       
/*  95 */       BonemealEvent event = new BonemealEvent(par2EntityPlayer, par3World, var11, par4, par5, par6);
/*  96 */       if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */       {
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       if (event.getResult() == Event.Result.ALLOW) {
/*     */         
/* 103 */         if (!par3World.field_72995_K)
/*     */         {
/* 105 */           par1ItemStack.field_77994_a--;
/*     */         }
/* 107 */         return true;
/*     */       } 
/*     */     } 
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_111207_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
/* 117 */     if (par3EntityLivingBase instanceof EntitySheep) {
/*     */       
/* 119 */       EntitySheep entitysheep = (EntitySheep)par3EntityLivingBase;
/* 120 */       int var4 = BlockColored.func_150032_b(par1ItemStack.func_77960_j());
/*     */       
/* 122 */       if (!entitysheep.func_70892_o() && entitysheep.func_70896_n() != var4) {
/*     */         
/* 124 */         entitysheep.func_70891_b(var4);
/* 125 */         par1ItemStack.field_77994_a--;
/*     */       } 
/*     */       
/* 128 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/* 140 */     for (int var4 = 0; var4 < 16; var4++)
/*     */     {
/* 142 */       par3List.add(new ItemStack(par1, 1, var4));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemDyeCustom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */