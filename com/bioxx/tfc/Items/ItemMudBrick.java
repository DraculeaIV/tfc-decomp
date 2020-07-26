/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMudBrick
/*     */   extends ItemTerra
/*     */ {
/*     */   private IIcon overlayIcon;
/*     */   
/*     */   public ItemMudBrick() {
/*  25 */     this.field_77787_bX = true;
/*  26 */     func_77656_e(0);
/*  27 */     setFolder("pottery/");
/*  28 */     func_77637_a(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*     */     int i;
/*  34 */     for (i = 0; i < Global.STONE_ALL.length; i++)
/*  35 */       list.add(new ItemStack(this, 1, i)); 
/*  36 */     for (i = 0; i < Global.STONE_ALL.length; i++) {
/*  37 */       list.add(new ItemStack(this, 1, i + 32));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  43 */     this.overlayIcon = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + "Mud Brick Overlay");
/*  44 */     super.func_94581_a(registerer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack itemstack) {
/*  50 */     if ((itemstack.func_77960_j() & 0x20) > 0)
/*  51 */       return "item.Wet Mud Brick"; 
/*  52 */     return super.func_77667_c(itemstack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int meta, int pass) {
/*  66 */     return (pass == 1) ? this.overlayIcon : super.func_77618_c(meta, pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack is, int pass) {
/*  73 */     int color = 16777215;
/*  74 */     if (pass == 0)
/*     */     {
/*  76 */       switch (is.func_77960_j() & 0x1F) {
/*     */         
/*     */         case 0:
/*  79 */           color = 10985616; break;
/*     */         case 1:
/*  81 */           color = 9210761; break;
/*     */         case 2:
/*  83 */           color = 5985361; break;
/*     */         case 3:
/*  85 */           color = 8683644; break;
/*     */         case 4:
/*  87 */           color = 13415322; break;
/*     */         case 5:
/*  89 */           color = 13947083; break;
/*     */         case 6:
/*  91 */           color = 12958367; break;
/*     */         case 7:
/*  93 */           color = 12299924; break;
/*     */         case 8:
/*  95 */           color = 7565170; break;
/*     */         case 9:
/*  97 */           color = 8674890; break;
/*     */         case 10:
/*  99 */           color = 13683909; break;
/*     */         case 11:
/* 101 */           color = 10130570; break;
/*     */         case 12:
/* 103 */           color = 5527384; break;
/*     */         case 13:
/* 105 */           color = 7962237; break;
/*     */         case 14:
/* 107 */           color = 9210763; break;
/*     */         case 15:
/* 109 */           color = 13548993; break;
/*     */         case 16:
/* 111 */           color = 11050380; break;
/*     */         case 17:
/* 113 */           color = 10260877; break;
/*     */         case 18:
/* 115 */           color = 10067336; break;
/*     */         case 19:
/* 117 */           color = 9605505; break;
/*     */         case 20:
/* 119 */           color = 13816272;
/*     */           break;
/*     */       }  } 
/* 122 */     if (is.func_77960_j() < 32)
/* 123 */       color -= 2236962; 
/* 124 */     return color;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 130 */     super.func_77624_a(is, player, arraylist, flag);
/* 131 */     if ((is.func_77960_j() & 0x1F) < 21) {
/* 132 */       arraylist.add(EnumChatFormatting.DARK_GRAY + Global.STONE_ALL[is.func_77960_j() & 0x1F]);
/*     */     } else {
/* 134 */       arraylist.add(EnumChatFormatting.DARK_RED + "Unknown: " + is.func_77960_j());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemMudBrick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */