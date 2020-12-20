import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let john = (splitOn "\n" contents) !! 0
  let doctor = (splitOn "\n" contents) !! 1
  if (able john doctor)
    then putStrLn ("go")
    else putStrLn ("no")

able :: String -> String -> Bool
able john doctor = (length john) >= (length doctor)
