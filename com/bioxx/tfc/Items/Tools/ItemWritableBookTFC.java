/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.nbt.NBTTagString;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemWritableBookTFC
/*     */   extends ItemTerra
/*     */ {
/*     */   public ItemWritableBookTFC() {
/*  20 */     this.stackable = false;
/*     */   }
/*     */   
/*     */   public ItemWritableBookTFC(String tex) {
/*  24 */     this.stackable = false;
/*  25 */     func_77637_a(null);
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
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer entityplayer) {
/*  41 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean validBookTagContents(NBTTagCompound par0NBTTagCompound) {
/*  46 */     if (!validBookTagPages(par0NBTTagCompound))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!par0NBTTagCompound.func_74764_b("title"))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  56 */     String var1 = par0NBTTagCompound.func_74779_i("title");
/*  57 */     return (var1 != null && var1.length() <= 16) ? par0NBTTagCompound.func_74764_b("author") : false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77651_p() {
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77653_i(ItemStack par1ItemStack) {
/*  73 */     if (par1ItemStack.func_77942_o()) {
/*     */       
/*  75 */       NBTTagCompound var2 = par1ItemStack.func_77978_p();
/*  76 */       NBTTagString var3 = (NBTTagString)var2.func_74781_a("title");
/*     */       
/*  78 */       if (var3 != null)
/*     */       {
/*  80 */         return var3.toString();
/*     */       }
/*     */     } 
/*     */     
/*  84 */     return super.func_77653_i(par1ItemStack);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
/*  89 */     if (par1ItemStack.func_77942_o()) {
/*     */       
/*  91 */       NBTTagCompound var5 = par1ItemStack.func_77978_p();
/*  92 */       NBTTagString var6 = (NBTTagString)var5.func_74781_a("author");
/*     */       
/*  94 */       if (var6 != null)
/*     */       {
/*  96 */         par3List.add("§7" + String.format(StatCollector.func_74837_a("book.byAuthor", new Object[] { var6.func_150285_a_() }), new Object[0]));
/*     */       }
/*     */     } 
/*  99 */     super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean validBookTagPages(NBTTagCompound par0NBTTagCompound) {
/* 104 */     if (par0NBTTagCompound == null)
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     if (!par0NBTTagCompound.func_74764_b("pages"))
/*     */     {
/* 110 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 114 */     NBTTagList var1 = (NBTTagList)par0NBTTagCompound.func_74781_a("pages");
/* 115 */     for (int var2 = 0; var2 < var1.func_74745_c(); var2++) {
/*     */       
/* 117 */       String var3 = var1.func_150307_f(var2);
/* 118 */       if (var3.isEmpty())
/* 119 */         return false; 
/* 120 */       if (var3.length() > 256)
/* 121 */         return false; 
/*     */     } 
/* 123 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemWritableBookTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */