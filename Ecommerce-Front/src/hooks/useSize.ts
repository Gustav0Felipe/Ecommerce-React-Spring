import { useWindowSize } from "@uidotdev/usehooks"

export function useSize()
{
    const size = useWindowSize();

    return {
        width: size.width,
        height: size.height
    }
}