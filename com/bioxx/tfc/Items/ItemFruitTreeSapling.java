/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TileEntities.TEFruitTreeWood;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemFruitTreeSapling
/*     */   extends ItemTerra
/*     */ {
/*     */   private IIcon[] icons;
/*     */   
/*     */   public ItemFruitTreeSapling() {
/*  30 */     func_77656_e(0);
/*  31 */     func_77627_a(true);
/*  32 */     func_77637_a(TFCTabs.TFC_FOODS);
/*  33 */     this.metaNames = Global.FRUIT_META_NAMES;
/*  34 */     this.icons = new IIcon[this.metaNames.length];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  41 */     if (side == 1 && world.func_147439_a(x, y, z).func_149721_r() && world.func_147439_a(x, y, z).func_149662_c() && 
/*  42 */       TFC_Core.isSoil(world.func_147439_a(x, y, z)) && world
/*  43 */       .func_147437_c(x, y + 1, z) && !world.field_72995_K) {
/*     */ 
/*     */       
/*  46 */       int damage = stack.func_77960_j();
/*  47 */       if (damage >= this.metaNames.length) {
/*     */         
/*  49 */         damage -= 8;
/*  50 */         stack.func_77964_b(damage);
/*     */       } 
/*  52 */       world.func_147465_d(x, y + 1, z, TFCBlocks.fruitTreeWood, damage, 2);
/*     */       
/*  54 */       ((TEFruitTreeWood)world.func_147438_o(x, y + 1, z)).setTrunk(true);
/*  55 */       ((TEFruitTreeWood)world.func_147438_o(x, y + 1, z)).setHeight(0);
/*  56 */       ((TEFruitTreeWood)world.func_147438_o(x, y + 1, z)).initBirth();
/*     */       
/*  58 */       stack.field_77994_a--;
/*  59 */       return true;
/*     */     } 
/*     */     
/*  62 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  68 */     for (int i = 0; i < this.metaNames.length; i++)
/*     */     {
/*  70 */       list.add(new ItemStack(this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  77 */     for (int i = 0; i < this.metaNames.length; i++) {
/*  78 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/fruit trees/" + this.metaNames[i] + " Sapling");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IIcon func_77617_a(int meta) {
/*  84 */     return this.icons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77650_f(ItemStack par1ItemStack) {
/*  92 */     int damage = par1ItemStack.func_77960_j();
/*  93 */     if (damage >= this.metaNames.length) {
/*     */       
/*  95 */       damage -= 8;
/*  96 */       par1ItemStack.func_77964_b(damage);
/*     */     } 
/*  98 */     return func_77617_a(damage);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77647_b(int i) {
/* 104 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemFruitTreeSapling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */