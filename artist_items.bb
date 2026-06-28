
AppTitle "Artist Items"
Const screen_width = 1024: Const screen_height = 768
Graphics3D screen_width,screen_height,0,2

InitDX7Hack()
DisableTextureFilters()


;font = LoadFont("modern goth.ttf",60)
font = LoadFont("",30)

Const fps_cap = 60
fps_timer = CreateTimer(fps_cap)


light = CreateLight()

camera = CreateCamera()
CameraViewport camera,0,0,screen_width,screen_height
PositionEntity camera,0,1.5,-70
RotateEntity camera,0,0,0

yaw_rot_angle# = 0
yaw_rot_speed# = 1.0






item_pivot = CreatePivot()
PositionEntity item_pivot,0,-2,0



cd_mesh = LoadMesh("cd_object.b3d")
PositionEntity cd_mesh,0,2,40
RotateMesh cd_mesh,45,0,0
;RotateEntity cd_mesh,100,0,0
scale_factor = 1
ScaleEntity cd_mesh,scale_factor,scale_factor,scale_factor
cd_texture = LoadTexture("cd_model.png",2)
EntityTexture cd_mesh,cd_texture


pencil_mesh = LoadMesh("pencil_model.b3d")
PositionEntity pencil_mesh,0,2,-40
RotateMesh pencil_mesh,45,0,0
scale_factor = 1
ScaleEntity pencil_mesh,scale_factor,scale_factor,scale_factor
pencil_texture = LoadTexture("pencil_model.png")
EntityTexture pencil_mesh,pencil_texture

pen_mesh = LoadMesh("pen_model.b3d")
PositionEntity pen_mesh,-20,2,-20
RotateMesh pen_mesh,-45,0,0
scale_factor = 2.5
ScaleEntity pen_mesh,scale_factor,scale_factor,scale_factor
pen_texture = LoadTexture("pen.png")
EntityTexture pen_mesh,pen_texture

coffee_cup_mesh = LoadMesh("coffee_cup.b3d")
PositionEntity coffee_cup_mesh,-30,2,-10
RotateMesh coffee_cup_mesh,45,0,0
scale_factor = 3
ScaleEntity coffee_cup_mesh,scale_factor,scale_factor,scale_factor
coffee_cup_texture = LoadTexture("coffee_cup.png")
EntityTexture coffee_cup_mesh,coffee_cup_texture

;hat_mesh = LoadMesh("jacks_witch_hat.b3d")
;ScaleEntity hat_mesh,1.3,1.3,1.3
;PositionEntity hat_mesh,0,1,2
;EntityParent hat_mesh,jack_mesh

;CameraClsColor camera,29,43,83


EntityParent cd_mesh,item_pivot
EntityParent pencil_mesh,item_pivot
EntityParent pen_mesh,item_pivot
EntityParent coffee_cup_mesh,item_pivot



CameraClsColor camera,0,0,0
Const ESC_KEY = 1
run = True
While run
	WaitTimer(fps_timer)
	If KeyHit(ESC_KEY) Then
		run = False
	EndIf
	
;	RotateEntity stool_mesh,0,yaw_rot_angle#,0
	
	RotateEntity cd_mesh,0,yaw_rot_angle#,0
	RotateEntity item_pivot,0,yaw_rot_angle#,0
	
	RotateEntity pencil_mesh,0,yaw_rot_angle#,0
	RotateEntity item_pivot,0,yaw_rot_angle#,0
	
	RotateEntity pen_mesh,0,yaw_rot_angle#,0
	RotateEntity item_pivot,0,yaw_rot_angle#,0
	
	RotateEntity coffee_cup_mesh,0,yaw_rot_angle#,0
	RotateEntity item_pivot,0,yaw_rot_angle#,0
	
	yaw_rot_angle# = yaw_rot_angle# + yaw_rot_speed#
	If yaw_rot_angle# > 360 Then
		yaw_rot_angle# = 0
	EndIf
	
	UpdateWorld
	RenderWorld
	
	SetFont font
	Color 255,0,255
	Text screen_width/2,screen_height*0.9,"Tools of the Trade (Modeled in PicoCad 2)",True,True
	
	
	Flip	
Wend
FlushKeys
WaitKey
End




Const D3DTSS_MAGFILTER = 16
Const D3DTSS_MINFILTER = 17
Const D3DTSS_MIPFILTER = 18
;Const D3DTSS_MIPMAPLODBIAS = 19
;Const D3DTSS_MAXMIPLEVEL = 20

Const D3DTEXF_NONE = 0 
Const D3DTEXF_POINT = 1
Const D3DTEXF_LINEAR = 2

Function InitDX7Hack()
	DX7DBF_SetSystemProperties( SystemProperty("Direct3D7"), SystemProperty("Direct3DDevice7"), SystemProperty("DirectDraw7"), SystemProperty("AppHWND"), SystemProperty("AppHINSTANCE") )
End Function

Function DisableTextureFilters()
	;DX7DBF_SetMipmapLODBias( -10.0, 0 )
	For Level = 0 To 7
		DX7DBF_SetTextureStageState( Level, D3DTSS_MAGFILTER, D3DTEXF_POINT )
		DX7DBF_SetTextureStageState( Level, D3DTSS_MINFILTER, D3DTEXF_POINT )
		DX7DBF_SetTextureStageState( Level, D3DTSS_MIPFILTER, D3DTEXF_POINT  )
	Next
End Function














































;AppTitle "Essential Items"
;Const screen_width = 1024 : Const screen_height = 768
;Graphics3D screen_width,screen_height,0,2
;SeedRnd MilliSecs
;Const fps_cap = 60
;fps_timer = CreateTimer(fps_cap)
;
;Const ESC_KEY = 1
;
;InitDX7Hack()
;DisableTextureFilters()
;
;
;
;light = CreateLight()
;
;camera = CreateCamera()
;CameraViewport camera,0,0,screen_width,screen_height
;PositionEntity camera,0,0,0
;RotateEntity camera,0,0,0
;
;
;pivot_point = CreatePivot()
;PositionEntity pivot_point,0,0,10
;
;cd_model_mesh = LoadMesh("cd_object.b3d")
;PositionEntity cd_model_mesh,0,0,0
;ScaleEntity cd_model_mesh,2,2,2
;
;cd_texture = LoadTexture("cd_model.png")
;EntityTexture cd_model_mesh,cd_texture
;
;
;CameraClsColor camera,0,42,64
;run = True
;While run
;	WaitTimer(fps_timer)
;	If KeyHit(ESC_KEY) Then
;		run = False
;	EndIf
;	
;	
;	UpdateWorld
;	
;	RenderWorld
;	
;	
;	Flip
;Wend
;FlushKeys
;WaitKey
;End



;Const D3DTSS_MAGFILTER = 16
;Const D3DTSS_MINFILTER = 17
;Const D3DTSS_MIPFILTER = 18
;;Const D3DTSS_MIPMAPLODBIAS = 19
;;Const D3DTSS_MAXMIPLEVEL = 20
;
;Const D3DTEXF_NONE = 0 
;Const D3DTEXF_POINT = 1
;Const D3DTEXF_LINEAR = 2
;
;Function InitDX7Hack()
;	DX7DBF_SetSystemProperties( SystemProperty("Direct3D7"), SystemProperty("Direct3DDevice7"), SystemProperty("DirectDraw7"), SystemProperty("AppHWND"), SystemProperty("AppHINSTANCE") )
;End Function
;
;Function DisableTextureFilters()
;	;DX7DBF_SetMipmapLODBias( -10.0, 0 )
;	For Level = 0 To 7
;		DX7DBF_SetTextureStageState( Level, D3DTSS_MAGFILTER, D3DTEXF_POINT )
;		DX7DBF_SetTextureStageState( Level, D3DTSS_MINFILTER, D3DTEXF_POINT )
;		DX7DBF_SetTextureStageState( Level, D3DTSS_MIPFILTER, D3DTEXF_POINT  )
;	Next
;End Function
;~IDEal Editor Parameters:
;~C#Blitz3D