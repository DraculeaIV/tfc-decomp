/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.Items.ItemTerra;
/*    */ import com.bioxx.tfc.TileEntities.TELoom;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemLooms
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemLooms(Block par1) {
/* 24 */     super(par1);
/* 25 */     func_77656_e(0);
/* 26 */     func_77627_a(true);
/* 27 */     func_77637_a(TFCTabs.TFC_DEVICES);
/* 28 */     this.metaNames = Global.WOOD_ALL;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumSize getSize(ItemStack is) {
/* 34 */     return EnumSize.LARGE;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumWeight getWeight(ItemStack is) {
/* 40 */     return EnumWeight.HEAVY;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77624_a(ItemStack is, EntityPlayer player, List arraylist, boolean flag) {
/* 47 */     ItemTerra.addSizeInformation(is, arraylist);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
/* 54 */     if (!world.func_147465_d(x, y, z, this.field_150939_a, metadata & 0xF, 3))
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     if (world.func_147439_a(x, y, z) == this.field_150939_a) {
/*    */       
/* 61 */       this.field_150939_a.func_149689_a(world, x, y, z, (EntityLivingBase)player, stack);
/* 62 */       this.field_150939_a.func_149714_e(world, x, y, z, 0);
/*    */       
/* 64 */       if (world.func_147438_o(x, y, z) instanceof TELoom) {
/*    */         
/* 66 */         TELoom te = (TELoom)world.func_147438_o(x, y, z);
/* 67 */         if (te != null) {
/*    */           
/* 69 */           te.loomType = metadata;
/* 70 */           world.func_147471_g(x, y, z);
/*    */           
/* 72 */           int l = MathHelper.func_76128_c((player.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 73 */           byte byte0 = 0;
/* 74 */           if (l == 0)
/* 75 */             byte0 = 0; 
/* 76 */           if (l == 1)
/* 77 */             byte0 = 1; 
/* 78 */           if (l == 2)
/* 79 */             byte0 = 2; 
/* 80 */           if (l == 3)
/* 81 */             byte0 = 3; 
/* 82 */           te.rotation = byte0;
/*    */         } 
/*    */       } 
/*    */     } 
/* 86 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 93 */     for (int i = 0; i < this.metaNames.length; i++)
/* 94 */       list.add(new ItemStack((Item)this, 1, i)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemLooms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */