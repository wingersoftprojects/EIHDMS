##
## CheckIn file or undo CheckOut with PowerShell
##
 
# Loading the SharePoint PowerShell Snapin if not already loaded
if ((Get-PsSnapin | ?{$_.Name -eq "Microsoft.SharePoint.PowerShell"})-eq $null)
{
  $PSSnapin = Add-PsSnapin Microsoft.SharePoint.PowerShell -ErrorAction SilentlyContinue
}
 
# define Variables
$targetWeb = "http://nhq-sv-103"
$targetLibrary = "/_catalogs/masterpage/Forms"
$fileName = "thebridgemaster.html"
 
$myWeb = Get-SPWeb $targetWeb
$myLib = $myWeb.GetFolder($targetLibrary)
$myFile = $myLib.Files | ? {$_.name -eq $fileName}
 
# for CheckIn use the following line otherwise comment it out with a #
#$myFile.CheckIn("MyCheckIn Comment")
# or to undo the CheckOut use the line below
$myFile.UndoCheckOut()
 
$myFile.Update()