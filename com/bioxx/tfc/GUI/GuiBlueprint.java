/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.ItemNBTPacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiBlueprint
/*     */   extends GuiScreen
/*     */ {
/*     */   private World world;
/*     */   private EntityPlayer player;
/*     */   private ItemStack stack;
/*     */   private GuiTextField nameTextField;
/*     */   private static final int X_MINUS_BUTTON = 0;
/*     */   private static final int X_PLUS_BUTTON = 1;
/*     */   private static final int Y_MINUS_BUTTON = 2;
/*     */   private static final int Y_PLUS_BUTTON = 3;
/*     */   private static final int Z_MINUS_BUTTON = 4;
/*     */   private static final int Z_PLUS_BUTTON = 5;
/*     */   private static final int DONE_BUTTON = 6;
/*     */   private static final int CANCEL_BUTTON = 7;
/*     */   private static final String DONE_NAME = "gui.done";
/*     */   private static final String CANCEL_NAME = "gui.cancel";
/*     */   private int xAngle;
/*     */   private int yAngle;
/*     */   private int zAngle;
/*  49 */   protected int xSize = 200;
/*     */ 
/*     */   
/*  52 */   protected int ySize = 172;
/*     */ 
/*     */   
/*     */   protected int guiLeft() {
/*  56 */     return (this.field_146294_l - this.xSize) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int guiTop() {
/*  61 */     return (this.field_146295_m - this.ySize) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiBlueprint(EntityPlayer p, World world, int i, int j, int k) {
/*  66 */     this.world = world;
/*  67 */     this.player = p;
/*  68 */     this.stack = this.player.field_71071_by.func_70448_g();
/*  69 */     if (this.stack.func_77942_o()) {
/*     */       
/*  71 */       this.xAngle = this.stack.field_77990_d.func_74762_e("xAngle");
/*  72 */       this.yAngle = this.stack.field_77990_d.func_74762_e("yAngle");
/*  73 */       this.zAngle = this.stack.field_77990_d.func_74762_e("zAngle");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/*  80 */     this.nameTextField.func_146178_a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  86 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  92 */     super.func_73866_w_();
/*     */     
/*  94 */     int nameTop = guiTop() + 10 + this.field_146289_q.field_78288_b + 4;
/*  95 */     this.nameTextField = new GuiTextField(this.field_146289_q, guiLeft() + 14, nameTop, 176, 20);
/*  96 */     this.nameTextField.func_146195_b(true);
/*  97 */     this.nameTextField.func_146205_d(false);
/*  98 */     if (!this.stack.func_77942_o() || this.stack.field_77990_d
/*  99 */       .func_74779_i("ItemName").isEmpty()) {
/*     */       
/* 101 */       this.nameTextField.func_146180_a("name_it");
/* 102 */       this.nameTextField.func_146190_e(0);
/* 103 */       this.nameTextField.func_146199_i(this.nameTextField.func_146179_b().length());
/*     */     }
/*     */     else {
/*     */       
/* 107 */       this.nameTextField.func_146184_c(false);
/* 108 */       this.nameTextField.func_146195_b(false);
/* 109 */       this.nameTextField.func_146180_a(this.stack.field_77990_d.func_74779_i("ItemName"));
/*     */     } 
/*     */     
/* 112 */     Keyboard.enableRepeatEvents(true);
/* 113 */     int buttonsA = 20;
/* 114 */     int buttonsTop = nameTop + 20 + 4;
/* 115 */     int buttonsLeftF = guiLeft() + 10 + this.field_146289_q.func_78256_a("X:") + 4;
/* 116 */     int buttonsLeftS = buttonsLeftF + buttonsA + 4 + this.field_146289_q.func_78256_a("360") + 4;
/*     */     
/* 118 */     this.field_146292_n.clear();
/* 119 */     this.field_146293_o.clear();
/*     */ 
/*     */     
/* 122 */     this.field_146292_n.add(new GuiButton(0, buttonsLeftF, buttonsTop, buttonsA, buttonsA, "<"));
/* 123 */     this.field_146292_n.add(new GuiButton(1, buttonsLeftS, buttonsTop, buttonsA, buttonsA, ">"));
/*     */ 
/*     */     
/* 126 */     buttonsTop += buttonsA + 4;
/* 127 */     this.field_146292_n.add(new GuiButton(2, buttonsLeftF, buttonsTop, buttonsA, buttonsA, "<"));
/* 128 */     this.field_146292_n.add(new GuiButton(3, buttonsLeftS, buttonsTop, buttonsA, buttonsA, ">"));
/*     */ 
/*     */     
/* 131 */     buttonsTop += buttonsA + 4;
/* 132 */     this.field_146292_n.add(new GuiButton(4, buttonsLeftF, buttonsTop, buttonsA, buttonsA, "<"));
/* 133 */     this.field_146292_n.add(new GuiButton(5, buttonsLeftS, buttonsTop, buttonsA, buttonsA, ">"));
/*     */ 
/*     */     
/* 136 */     int doneWidth = this.field_146289_q.func_78256_a(TFC_Core.translate("gui.done")) + 20;
/* 137 */     this.field_146292_n.add(new GuiButton(6, (this.field_146294_l + this.xSize) / 2 - 10 - doneWidth, (this.field_146295_m + this.ySize) / 2 - 10 - buttonsA, doneWidth, buttonsA, 
/*     */ 
/*     */ 
/*     */           
/* 141 */           TFC_Core.translate("gui.done")));
/*     */ 
/*     */ 
/*     */     
/* 145 */     int cancelWidth = this.field_146289_q.func_78256_a(TFC_Core.translate("gui.cancel")) + 20;
/* 146 */     this.field_146292_n.add(new GuiButton(7, (this.field_146294_l + this.xSize) / 2 - 10 - doneWidth - cancelWidth - 4, (this.field_146295_m + this.ySize) / 2 - 10 - buttonsA, cancelWidth, buttonsA, 
/*     */ 
/*     */ 
/*     */           
/* 150 */           TFC_Core.translate("gui.cancel")));
/*     */   }
/*     */ 
/*     */   
/* 154 */   public static RenderItem itemRenderer = new RenderItem();
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int par1, int par2, int par3) {
/* 159 */     super.func_73864_a(par1, par2, par3);
/* 160 */     this.nameTextField.func_146192_a(par1, par2, par3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char par1, int par2) {
/* 166 */     this.nameTextField.func_146201_a(par1, par2);
/* 167 */     ((GuiButton)this.field_146292_n.get(6)).field_146124_l = (this.nameTextField.func_146179_b().trim().length() > 0);
/* 168 */     if (par1 == '\r') {
/* 169 */       func_146284_a(this.field_146292_n.get(6));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73732_a(FontRenderer fontrenderer, String s, int i, int j, int k) {
/* 181 */     fontrenderer.func_78276_b(s, i - fontrenderer.func_78256_a(s) / 2, j, k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/* 187 */     if (!this.world.field_72995_K) {
/*     */       return;
/*     */     }
/* 190 */     if (guibutton.field_146127_k == 0) {
/* 191 */       this.xAngle = (this.xAngle == 0) ? 270 : (this.xAngle - 90);
/* 192 */     } else if (guibutton.field_146127_k == 1) {
/* 193 */       this.xAngle = (this.xAngle == 270) ? 0 : (this.xAngle + 90);
/* 194 */     } else if (guibutton.field_146127_k == 2) {
/* 195 */       this.yAngle = (this.yAngle == 0) ? 270 : (this.yAngle - 90);
/* 196 */     } else if (guibutton.field_146127_k == 3) {
/* 197 */       this.yAngle = (this.yAngle == 270) ? 0 : (this.yAngle + 90);
/* 198 */     } else if (guibutton.field_146127_k == 4) {
/* 199 */       this.zAngle = (this.zAngle == 0) ? 270 : (this.zAngle - 90);
/* 200 */     } else if (guibutton.field_146127_k == 5) {
/* 201 */       this.zAngle = (this.zAngle == 270) ? 0 : (this.zAngle + 90);
/* 202 */     } else if (guibutton.field_146127_k == 6) {
/* 203 */       this.stack.field_77990_d.func_74757_a("Completed", true);
/* 204 */       this.stack.field_77990_d.func_74778_a("ItemName", this.nameTextField.func_146179_b());
/* 205 */       this.stack.field_77990_d.func_74768_a("xAngle", this.xAngle);
/* 206 */       this.stack.field_77990_d.func_74768_a("yAngle", this.yAngle);
/* 207 */       this.stack.field_77990_d.func_74768_a("zAngle", this.zAngle);
/*     */       
/* 209 */       ItemNBTPacket itemNBTPacket = new ItemNBTPacket(this.stack.field_77990_d);
/* 210 */       itemNBTPacket
/* 211 */         .addAcceptedTag("Completed")
/* 212 */         .addAcceptedTag("ItemName")
/* 213 */         .addAcceptedTag("xAngle")
/* 214 */         .addAcceptedTag("yAngle")
/* 215 */         .addAcceptedTag("zAngle");
/*     */       
/* 217 */       TerraFirmaCraft.PACKET_PIPELINE.sendToServer((AbstractPacket)itemNBTPacket);
/*     */       
/* 219 */       Minecraft.func_71410_x().func_147108_a(null);
/*     */     }
/* 221 */     else if (guibutton.field_146127_k == 7) {
/* 222 */       if (!this.stack.field_77990_d.func_74767_n("Completed")) {
/* 223 */         this.stack.func_77982_d(new NBTTagCompound());
/* 224 */         ItemNBTPacket itemNBTPacket = new ItemNBTPacket(this.stack.field_77990_d);
/* 225 */         itemNBTPacket
/* 226 */           .addRemoveTag("Completed")
/* 227 */           .addRemoveTag("ItemName")
/* 228 */           .addRemoveTag("Data")
/* 229 */           .addRemoveTag("xAngle")
/* 230 */           .addRemoveTag("yAngle")
/* 231 */           .addRemoveTag("zAngle");
/* 232 */         TerraFirmaCraft.PACKET_PIPELINE.sendToServer((AbstractPacket)itemNBTPacket);
/*     */       } 
/*     */       
/* 235 */       Minecraft.func_71410_x().func_147108_a(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int par1, int par2, float par3) {
/* 242 */     TFC_Core.bindTexture(new ResourceLocation("terrafirmacraft", "textures/gui/gui_blueprint.png"));
/*     */     
/* 244 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 245 */     int left = guiLeft();
/* 246 */     int top = guiTop();
/* 247 */     func_73729_b(left, top, 0, 0, this.xSize, this.ySize);
/*     */     
/* 249 */     if (!this.stack.func_77942_o() || this.stack.field_77990_d.func_74779_i("ItemName").isEmpty()) {
/* 250 */       func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Blueprint"), this.field_146294_l / 2, top + 10, 0);
/*     */     } else {
/* 252 */       func_73732_a(this.field_146289_q, TFC_Core.translate("gui.Rotate"), this.field_146294_l / 2, top + 10, 0);
/*     */     } 
/* 254 */     int axesNameLeft = left + 10;
/* 255 */     int axesAngleLeft = axesNameLeft + this.field_146289_q.func_78256_a("X: ") + 4 + 20 + this.field_146289_q.func_78256_a("360") / 2;
/* 256 */     int topShift = (20 - this.field_146289_q.field_78288_b) / 2;
/*     */     
/* 258 */     top += 10 + this.field_146289_q.field_78288_b + 4;
/* 259 */     this.nameTextField.func_146194_f();
/*     */ 
/*     */     
/* 262 */     top += 24;
/* 263 */     this.field_146289_q.func_78276_b("X:", axesNameLeft, top + topShift, 0);
/* 264 */     func_73732_a(this.field_146289_q, String.valueOf(this.xAngle), axesAngleLeft, top + topShift, 0);
/*     */ 
/*     */     
/* 267 */     top += 24;
/* 268 */     this.field_146289_q.func_78276_b("Y:", axesNameLeft, top + topShift, 0);
/* 269 */     func_73732_a(this.field_146289_q, String.valueOf(this.yAngle), axesAngleLeft, top + topShift, 0);
/*     */ 
/*     */     
/* 272 */     top += 24;
/* 273 */     this.field_146289_q.func_78276_b("Z:", axesNameLeft, top + topShift, 0);
/* 274 */     func_73732_a(this.field_146289_q, String.valueOf(this.zAngle), axesAngleLeft, top + topShift, 0);
/*     */     
/* 276 */     super.func_73863_a(par1, par2, par3);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiBlueprint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */